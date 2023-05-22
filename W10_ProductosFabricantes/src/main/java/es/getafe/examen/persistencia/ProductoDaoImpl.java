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
		TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p WHERE p.producto LIKE :descripcion",
				Producto.class);
		q.setParameter("descripcion", "%" + descripcion + "%");
		productos = q.getResultList();
		em.close();
		return productos;
	}

	@Override
	public List<Producto> findAll() {
		em = EMF.getEmf().createEntityManager();
		List<Producto> productos = null;
		TypedQuery<Producto> q = em.createQuery("SELECT p FROM Producto p", Producto.class);
		productos = q.getResultList();
		em.close();
		return productos;
	}

	@Override
	public void save(Producto p) {
		em = EMF.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}

}
