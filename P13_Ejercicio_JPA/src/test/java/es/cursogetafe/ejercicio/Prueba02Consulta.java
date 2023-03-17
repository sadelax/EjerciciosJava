package es.cursogetafe.ejercicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.cursogetafe.ejercicio.modelo.Cliente;
import es.cursogetafe.ejercicio.modelo.Producto;
import util.EMF;

public class Prueba02Consulta {

	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
		String buscado = "disco";
		
//		String jpql = "SELECT p FROM Producto p WHERE p.idProducto = 5";
//		String jpql = "SELECT p FROM Producto p WHERE p.producto like '%disco%'";
		String jpql = "SELECT p FROM Producto p WHERE p.producto like :prod";
		TypedQuery<Producto> q = em.createQuery(jpql, Producto.class);
		q.setParameter("prod", "%" + buscado + "%");
		List<Producto> prods = q.getResultList();
		
		for(Producto p : prods) {
			System.out.println(p);
			for(Cliente c : p.getClientes()) {
				System.out.println(c.getApellidos());
			}
		}
		
		em.close();
	}
}
