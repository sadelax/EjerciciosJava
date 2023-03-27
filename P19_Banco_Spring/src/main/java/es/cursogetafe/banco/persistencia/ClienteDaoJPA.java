package es.cursogetafe.banco.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(entidad);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Cliente findById(Integer id) {
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Cliente c LEFT JOIN c.cuentas WHERE c.idCliente = :id";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", id);
		Cliente c = q.getSingleResult();
		return c;
	}

	@Override
	public Cliente findbyIdEager(Integer id) {
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Cliente c LEFT JOIN FETCH c.cuentas WHERE c.idCliente = :id";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", id);
		Cliente c = q.getSingleResult();
		return c;
	}

	@Override
	public Set<Cliente> findAll() {
		em = emf.createEntityManager();
		String jpql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		Set<Cliente> listado = new TreeSet<>(q.getResultList());
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
				+ "c.nombre = :valor OR "
				+ "c.apellido1 = :valor OR "
				+ "c.apellido2 = :valor OR "
				+ "c.municipio = :valor OR "
				+ "c.provincia = :valor OR "
				+ "c.nif = :valor";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("valor", "%" + valor + "%");
		List<Cliente> listado = new ArrayList<>(q.getResultList());
		return listado;
	}

}
