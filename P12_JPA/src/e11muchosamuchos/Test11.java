package e11muchosamuchos;

import javax.persistence.EntityManager;

import util.EMF;

public class Test11 {

	public static void main(String[] args) {
		EntityManager em = EMF.getEmf().createEntityManager();
		
		Jugador j = em.find(Jugador.class, 5);
		if(j != null) {
			System.out.println(j);
			for (Equipo equipo : j.getEquipos()) {
				System.out.println(equipo);
			}
		}
		
		Equipo e = em.find(Equipo.class, 14);
		if(e != null) {
			System.out.println(e);
			for(Jugador jugador : e.getJugadores()) {
				System.out.println(jugador);
			}
		}
		
		em.close();
	}
}
