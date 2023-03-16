package e04pkcompuestaidclass;

import javax.persistence.EntityManager;

import util.EMF;

public class Test04 {

	public static void main(String[] args) {
		
		EntityManager em = EMF.getEmf().createEntityManager();
		
		Persona04 nuevo = new Persona04();
		nuevo.setDni(50770005);
		nuevo.setLetra('S');
		nuevo.setNombre("paco");
		
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		em.close();
		EMF.getEmf().close();
	}
}
