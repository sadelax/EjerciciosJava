package e06;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test06 {
	public static void main(String[] args) {
		// equivalente al datasource
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebasJPA"); // le pasamos el nombre de la unidad de persistencia
		
		// equivalente a connection + prep statement
		EntityManager em = emf.createEntityManager();
		
		Persona06 p = em.find(Persona06.class, 12);
		if(p != null) {
			System.out.println(p.getApellidos() + " " + p.getApodo());
			System.out.println(p.getNombreCompleto());
			p.setApodo("Chapulin Colorado");
		}
		
		// sigo currando ... ...
		
		Persona06 nuevo = new Persona06();
		nuevo.setApellidos("Perez");
		nuevo.setApodo("Paco");
		nuevo.setDni("sin_papeles");
		nuevo.setNombre("No tiene");
		
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
