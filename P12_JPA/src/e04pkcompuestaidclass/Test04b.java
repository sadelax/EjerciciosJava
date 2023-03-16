package e04pkcompuestaidclass;

import javax.persistence.EntityManager;

import util.EMF;

public class Test04b {
	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
		Persona04Id pId = new Persona04Id();
		pId.setDni(1230321);
		pId.setLetra('a');
		
		Persona04 p = em.find(Persona04.class, pId);
		
		if(p != null) {
			System.out.println(p.getNombre());
		}
		
		em.close();
		EMF.getEmf().createEntityManager();
	}
}
