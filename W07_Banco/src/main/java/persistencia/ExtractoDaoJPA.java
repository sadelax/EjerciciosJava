package persistencia;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Cuenta;
import modelo.Extracto;
import util.EMF;

public class ExtractoDaoJPA implements ExtractoDao {
	
	private EntityManager em;

	@Override
	public void save(Extracto entidad) {
		em = EMF.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(entidad);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Extracto findById(Integer id) {
		em = EMF.getEmf().createEntityManager();
		Extracto e = em.find(Extracto.class, id);
		em.close();
		return e;
	}

	@Override
	public Extracto findByIdEager(Integer id) {
		Extracto encontrado;
		em = EMF.getEmf().createEntityManager();
		String jpql = "SELECT e FROM Extracto e LEFT JOIN FETCH e.movimientos WHERE e.idExtracto = :id";
		TypedQuery<Extracto> q = em.createQuery(jpql, Extracto.class);
		q.setParameter("id", id);
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
		em = EMF.getEmf().createEntityManager();
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
		em = EMF.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.remove(entidad);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Extracto extractoFechaEager(Cuenta c, int anyo, int mes) {
		Extracto generado;
		em = EMF.getEmf().createEntityManager();
		String jpql = "SELECT e FROM Extracto e "
				+ "JOIN FETCH e.movimientos "
				+ "JOIN FETCH e.cuenta cue "
				+ "JOIN FETCH cue.tarjetas "
				+ "WHERE e.cuenta = :c "
				+ "AND e.anyo = :anyo "
				+ "AND e.mes =:mes";
		TypedQuery<Extracto> q = em.createQuery(jpql,Extracto.class);
		q.setParameter("c", c);
		q.setParameter("anyo", anyo);
		q.setParameter("mes", mes);
		try {
			generado = q.getSingleResult();
		} catch(NoResultException e) {
			generado = null;
		}
		return generado;
	}
}
