package e10muchosauno;

import javax.persistence.EntityManager;

import util.EMF;

public class Test10 {

	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
		// eager by default (partido-campo es ManyToOne)
		Partido p = em.find(Partido.class, 3);
		System.out.println(p.getIdpartido() + " ");
		System.out.println(p.getPartido() + " ");
		System.out.println(p.getCampo().getIdcampo() + " ");
		System.out.println(p.getCampo().getCampo());
		
		// lazy by default (campo-partido es OneToMany)
		Campo c = em.find(Campo.class, 1);
		System.out.println(c.getCampo());
		for (Partido partido : c.getPartidos()) {
			System.out.println(partido.getPartido());
		}
		
		em.close();
	}
}
