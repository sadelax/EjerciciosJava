package es.cursogetafe.banco.modelo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.cursogetafe.banco.modelo.Cliente;
import es.cursogetafe.banco.modelo.Genero;

public class TestCarga {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco_Spring");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente("sandra", "delac", "507700161d", Genero.H, "madrid", "madrid");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
