package es.getafe.examen.persistencia;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import es.getafe.examen.modelo.Fabricante;
import util.EMF;

public class FabricanteDaoImpl implements FabricanteDao {

	private EntityManager em;

	@Override
	public void save(Fabricante fabricante) {
		em = EMF.getEmf().createEntityManager();
		try {
			TypedQuery<Fabricante> q = em.createQuery("SELECT f FROM Fabricante f WHERE f.idFabricante = :id",
					Fabricante.class);
			q.setParameter("id", fabricante.getIdFabricante());
			List<Fabricante> res = q.getResultList();
			if (res.isEmpty()) {
				em.getTransaction().begin();
				em.merge(fabricante);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}

	@Override
	public Fabricante findByIdLazy(int idFabricante) {
		em = EMF.getEmf().createEntityManager();
		Fabricante f = em.find(Fabricante.class, idFabricante);
		em.close();
		return f;
	}

	@Override
	public Fabricante findById(int idFabricante) {
		em = EMF.getEmf().createEntityManager();
		Fabricante f;
		TypedQuery<Fabricante> q = em.createQuery(
				"SELECT f FROM Fabricante f LEFT JOIN FETCH f.productos WHERE f.idFabricante = :id", Fabricante.class);
		q.setParameter("id", idFabricante);
		try {
			f = q.getSingleResult();
		} catch (NoResultException e) {
			f = null;
		}
		em.close();
		return f;
	}

	@Override
	public Set<Fabricante> findOnlyActive() {
		em = EMF.getEmf().createEntityManager();
		Set<Fabricante> fabricantes = null;
		TypedQuery<Fabricante> q = em.createQuery("SELECT DISTINCT f FROM Fabricante f JOIN f.productos",
				Fabricante.class);
		fabricantes = new TreeSet<>(q.getResultList());
		em.close();
		return fabricantes;
	}

	@Override
	public Set<Fabricante> findAll() {
		em = EMF.getEmf().createEntityManager();
		Set<Fabricante> fabricantes = null;
		TypedQuery<Fabricante> q = em.createQuery("SELECT f FROM Fabricante f", Fabricante.class);
		fabricantes = new TreeSet<>(q.getResultList());
		em.close();
		return fabricantes;
	}
}
