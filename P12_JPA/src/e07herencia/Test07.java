package e07herencia;

import javax.persistence.EntityManager;

import util.EMF;

public class Test07 {
	
	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
		Circulo c = new Circulo();
		c.setX(98);
		c.setY(21);
		c.setR(5);
		
		Rectangulo r = new Rectangulo();
		r.setX(45);
		r.setY(23);
		r.setL1(76);
		r.setL2(12);
		
		em.getTransaction().begin();
		em.persist(c);
		em.persist(r);
		em.getTransaction().commit();
				
		Figura findRect = em.find(Figura.class, 37);
		if (findRect != null) {
			System.out.println(findRect);
		}
		
		em.close();
		EMF.getEmf().close();
	}

}
