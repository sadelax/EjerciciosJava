package e08herencia;

import javax.persistence.EntityManager;

import util.EMF;

public class Test08 {
	
	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
		Circulo02 c = new Circulo02(98, 21, 5);
		em.persist(c);
		
		Rectangulo02 r = new Rectangulo02(45, 23, 76, 12);
		em.persist(r);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
				
		Figura02 findRect = em.find(Figura02.class, 37);
		if (findRect != null) {
			System.out.println(findRect);
		}
		
		em.close();
		EMF.getEmf().close();
	}

}
