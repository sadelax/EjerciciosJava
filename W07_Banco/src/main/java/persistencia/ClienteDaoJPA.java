package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Cliente;
import util.EMF;

public class ClienteDaoJPA implements ClienteDao {

	private EntityManager em;
	
	@Override
	public void save(Cliente entidad) {
		em = EMF.getEmf().createEntityManager();
		if (entidad.getNif() == null) {
			em.getTransaction().begin();
			em.merge(entidad);
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public Cliente findById(Integer id) {
		em = EMF.getEmf().createEntityManager();		Cliente c = em.find(Cliente.class, id);
		em.close();
		return c;
	}

	@Override
	public Cliente findByIdEager(Integer id) {
		Cliente c;
		em = EMF.getEmf().createEntityManager();		String jpql = "SELECT c FROM Cliente c LEFT JOIN FETCH c.cuentas WHERE c.idCliente = :id";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", id);
		try {
			c = q.getSingleResult();
		} catch (NoResultException e) {
			c = null;
		}
		c = q.getSingleResult();
		em.close();
		return c;
	}

	@Override
	public Set<Cliente> findAll() {
		Set<Cliente> listado;
		em = EMF.getEmf().createEntityManager();		String jpql = "SELECT c FROM Cliente c";
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
		em = EMF.getEmf().createEntityManager();		if(entidad != null) {
			em.getTransaction().begin();
			em.remove(entidad);
			em.getTransaction().commit();
		}
		em.close();
	}

	@Override
	public List<Cliente> findByValue(String valor) {
		em = EMF.getEmf().createEntityManager();		String jpql = "SELECT c FROM Cliente c WHERE "
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
