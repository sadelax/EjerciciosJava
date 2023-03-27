package agenda.persistencia;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import agenda.modelo.Contacto;

@Repository("contactoDao")
public class ContactoDaoJPA implements ContactoDao{
	
	@Autowired
	@Qualifier("emf")
	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public void delete(int idContacto) {
		em = emf.createEntityManager();
		Contacto c = em.find(Contacto.class, idContacto);
		if(c != null) {
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public void save(Contacto contacto) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(contacto);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public Contacto findByIdEager(int idContacto) {
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Contacto c LEFT JOIN FETCH c.correos LEFT JOIN FETCH c.telefonos WHERE c.idContacto = :id";
		TypedQuery<Contacto> q = em.createQuery(jpql, Contacto.class);
		q.setParameter("id", idContacto);
 		Contacto c = q.getSingleResult();
		em.close();
		return c;
	}

	@Override
	public Set<Contacto> findByValue(String nom) {
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Contacto c WHERE c.apellidos LIKE :nom OR c.nombre LIKE :nom OR c.apodo LIKE :nom";
		TypedQuery<Contacto> q = em.createQuery(jpql, Contacto.class);
		q.setParameter("nom", "%" + nom + "%");
		Set<Contacto> resu = new TreeSet<>(q.getResultList());
		em.close();
		return resu;
	}

	@Override
	public Set<Contacto> findAll() {
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Contacto c";
		TypedQuery<Contacto> q = em.createQuery(jpql, Contacto.class);
		Set<Contacto> resu = new TreeSet<>(q.getResultList());
		em.close();
		return resu;
	}
}
