package e09elementcollection;

import java.util.Arrays;

import javax.persistence.EntityManager;

import util.EMF;

public class Test09 {
	public static void main(String[] args) {
		// equivalente al datasource
		EntityManager em = EMF.getEmf().createEntityManager();
		
		Persona09 p = em.find(Persona09.class, 1022);
		if(p != null) {
			System.out.println(p.getApellidos() + " " + p.getApodo());
			System.out.println(p.getNombreCompleto());
			for (String telefono: p.getTelefonos()) {
				System.out.println(telefono);
			}
		}
		
		
		Persona09 nuevo = new Persona09();
		nuevo.setApellidos("Perez");
		nuevo.setApodo("Paco");
		nuevo.setDni("sin_papeles");
		nuevo.setNombre("No tiene");
		nuevo.setTelefonos(Arrays.asList("642440711", "633101175"));
		
		em.getTransaction().begin();
		em.persist(nuevo);
		em.getTransaction().commit();
		
		em.close();
	}
}
