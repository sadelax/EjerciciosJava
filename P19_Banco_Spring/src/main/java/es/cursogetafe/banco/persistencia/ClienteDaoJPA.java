package es.cursogetafe.banco.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.cursogetafe.banco.modelo.Cliente;

@Repository("clienteDao")
public class ClienteDaoJPA implements ClienteDao {

	@Autowired
	@Qualifier("emf")
	private EntityManagerFactory emf;
	private EntityManager em;
	
	@Override
	public void save(Cliente entidad) {
		if (entidad.getNif() == null) {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(entidad);
			em.getTransaction().commit();
			em.close();			
		}
	}

	@Override
	public Cliente findById(Integer id) {
		em = emf.createEntityManager();
		Cliente t = em.find(Cliente.class, id);
		return t;
	}

	@Override
	public Cliente findByIdEager(Integer id) {
		Cliente c;
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Cliente c LEFT JOIN FETCH c.cuentas WHERE c.idCliente = :id";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", id);
		try {
			c = q.getSingleResult();
		} catch (NoResultException e) {
			c = null;
		}
		c = q.getSingleResult();
		return c;
	}

	@Override
	public Set<Cliente> findAll() {
		Set<Cliente> listado;
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		try {
			listado = new TreeSet<>(q.getResultList());			
		} catch (Exception e) {
			listado = null;
		}
		em.close();
		return listado;
	}

	@Override
	public void delete(Cliente entidad) {
		em = emf.createEntityManager();
		if(entidad != null) {
			em.getTransaction().begin();
			em.remove(entidad);
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public List<Cliente> findByValue(String valor) {
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Cliente c WHERE "
				+ "c.nombre like :valor OR "
				+ "c.apellido1 like :valor OR "
				+ "c.apellido2 like :valor";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("valor", "%" + valor + "%");
		List<Cliente> listado = new ArrayList<>(q.getResultList());
		em.close();
		return listado;
	}
}
