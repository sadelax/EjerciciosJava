package es.cursogetafe.banco.persistencia;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.cursogetafe.banco.modelo.Extracto;

@Repository("extractoDao")
public class ExtractoDaoJPA implements ExtractoDao {
	
	@Autowired
	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public void save(Extracto entidad) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entidad);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Extracto findById(Integer id) {
		em = emf.createEntityManager();
		Extracto e = em.find(Extracto.class, id);
		em.close();
		return e;
	}

	@Override
	public Extracto findByIdEager(Integer id) {
		Extracto encontrado;
		em = emf.createEntityManager();
		String jpql = "SELECT e FROM Extracto e LEFT JOIN FETCH e.movimientos WHERE idExtracto = :id";
		TypedQuery<Extracto> q = em.createQuery(jpql, Extracto.class);
		try {
			encontrado = q.getSingleResult();
		} catch (NoResultException e) {
			encontrado = null;
		}
		em.close();
		return encontrado;	
	}

	@Override
	public Set<Extracto> findAll() {
		Set<Extracto> listado;
		em = emf.createEntityManager();
		String jpql = "SELECT e FROM Extracto e";
		TypedQuery<Extracto> q = em.createQuery(jpql, Extracto.class);
		try {
			listado = new TreeSet<>(q.getResultList());
		} catch (Exception e) {
			listado = null;
		}
		em.close();
		return listado;
	}

	@Override
	public void delete(Extracto entidad) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(entidad);
		em.getTransaction().commit();
		em.close();
	}

}
