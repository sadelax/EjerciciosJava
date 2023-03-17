package es.cursogetafe.ejercicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.cursogetafe.ejercicio.modelo.Empleado;
import util.EMF;

public class Prueba03Consulta {

	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
//		String jpql = "SELECT e FROM Empleado e WHERE e.categoria.categoria LIKE '%jefe%'";	// categoria(atributo tipo Categoria de empleado).categoria(propiedad tipo String categoria)
		String jpql = "SELECT e FROM Empleado e WHERE e.categoria.idCategoria = 2";	//
		
		TypedQuery<Empleado> q = em.createQuery(jpql, Empleado.class);
		
		List<Empleado> emps = q.getResultList();
		
		for (Empleado empleado : emps) {
			System.out.println(empleado.getApellidos());
			System.out.println(empleado.getNroEmpleado());
		}
	}
}
