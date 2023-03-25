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
		
		Cliente c = new Cliente();
		c.setNombre("sandra");
		c.setApellido1("delacruZ");
		c.setNif("50770006g");
		c.setSexo(Genero.F);
		c.setMunicipio("Madrid");
		c.setProvincia("madrid");
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
