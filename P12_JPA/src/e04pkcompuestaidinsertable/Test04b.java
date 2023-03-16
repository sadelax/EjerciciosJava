package e04pkcompuestaidinsertable;

import javax.persistence.EntityManager;

import util.EMF;

public class Test04b {
	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
		Persona04bId pId = new Persona04bId();
		pId.setDni(1230321);
		pId.setLetra('a');
		
		Persona04b p = em.find(Persona04b.class, pId);
		
		if(p != null) {
			System.out.println(p.getNombre());
		}
		
		em.close();
		EMF.getEmf().createEntityManager();
	}
}
