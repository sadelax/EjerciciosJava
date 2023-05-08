package es.getafe.examen.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.getafe.examen.modelo.Producto;
import util.EMF;

public class ProductoDaoImpl implements ProductoDao {

	private EntityManager em;
	
	@Override
	public Producto findById(int idProducto) {
		em = EMF.getEmf().createEntityManager();
		Producto p = em.find(Producto.class, idProducto);
		em.close();
		return p;
	}

	@Override
	public List<Producto> findByDescripcion(String descripcion) {
		em = EMF.getEmf().createEntityManager();
		List<Producto> productos = null;
		TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p WHERE p.producto LIKE :descripcion", Producto.class);
		q.setParameter("descripcion", "%" + descripcion + "%");
		try {
			productos = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return productos;
	}

	@Override
	public List<Producto> findAll() {
		em = EMF.getEmf().createEntityManager();
		List<Producto> productos = null;
		TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p", Producto.class);
		try {
			productos = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return productos;
	}

	@Override
	public void save(Producto p) {
		em = EMF.getEmf().createEntityManager();
		try {
			TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto pWHERE f.idProducto = :id", Producto.class);
			q.setParameter("id", p.getIdProducto());
			List<Producto> res = q.getResultList();
			if (res.isEmpty()) {
				em.getTransaction().begin();
				em.merge(p);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}

}
