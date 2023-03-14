package e04b;

import javax.persistence.EntityManager;

import util.EMF;

public class Test04 {

	public static void main(String[] args) {
		
EntityManager em = EMF.getEmf().createEntityManager();
		
		Persona04b nuevo = new Persona04b();
		Persona04bId pId = new Persona04bId();
		pId.setDni(153855937);
		pId.setLetra('W');
		nuevo.setDni(pId);
		nuevo.setNombre("dani montero");
		
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		em.close();
		EMF.getEmf().createEntityManager();
	}
}
