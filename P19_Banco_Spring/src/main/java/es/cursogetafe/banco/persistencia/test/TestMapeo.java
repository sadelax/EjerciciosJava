package es.cursogetafe.banco.persistencia.test;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cursogetafe.banco.modelo.Cliente;
import es.cursogetafe.banco.modelo.Cuenta;
import es.cursogetafe.banco.modelo.Extracto;
import es.cursogetafe.banco.modelo.Movimiento;

//@Component
public class TestMapeo {
	
	@Autowired
	EntityManagerFactory emf;
	
	EntityManager em;

	@PostConstruct
	public void test() {
		em = emf.createEntityManager();
		Cliente c = em.find(Cliente.class, 12);
		System.out.println(c);
		
		for(Cuenta cuenta : c.getCuentas()) {
			System.out.println(cuenta.getTarjetas());
		}
		
		System.out.println("=================");
		Extracto e = em.find(Extracto.class, 20);
		System.out.println(e);
		
		for(Movimiento mov : e.getMovimientos()) {
			System.out.println(mov);
		}
	}
}
