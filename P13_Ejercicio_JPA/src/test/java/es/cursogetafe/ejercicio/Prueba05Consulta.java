package es.cursogetafe.ejercicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.cursogetafe.ejercicio.modelo.Cliente;
import es.cursogetafe.ejercicio.modelo.Producto;
import util.EMF;

public class Prueba05Consulta {

	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
				
		String jpql = "SELECT p FROM Producto p JOIN FETCH p.clientes c WHERE c.persona.apellidos LIKE '%lopez%'"; // se hace un JOIN de una lista
		TypedQuery<Producto> q = em.createQuery(jpql, Producto.class);

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
