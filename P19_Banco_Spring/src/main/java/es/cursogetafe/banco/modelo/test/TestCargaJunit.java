package es.cursogetafe.banco.modelo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import es.cursogetafe.banco.modelo.Cliente;
import es.cursogetafe.banco.modelo.Genero;

public class TestCargaJunit {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco_Spring");
		EntityManager em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() {
		em.close();
		emf.close();
	}
	
	@Test
	public void testCargaCliente() {
		Cliente c = new Cliente("sandra", "delac", "50770001d", Genero.H, "madrid", "madrid");
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
		Cliente clienteRecuperado = em.find(Cliente.class, c.getIdCliente());
		
		assertEquals(c.getNombre(), clienteRecuperado.getNombre());
		assertEquals(c.getApellido1(), clienteRecuperado.getApellido1());
		assertEquals(c.getNif(), clienteRecuperado.getNif());
		assertEquals(c.getGenero(), clienteRecuperado.getGenero());
		assertEquals(c.getProvincia(), clienteRecuperado.getProvincia());
		assertEquals(c.getMunicipio(), clienteRecuperado.getMunicipio());
	}
}
