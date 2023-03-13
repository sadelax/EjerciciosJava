package e02;

import javax.persistence.EntityManager;

import util.EMF;

public class Test02 {
	public static void main(String[] args) {
		// equivalente al datasource
		EntityManager em = EMF.getEmf().createEntityManager();
				
		Persona02 p = em.find(Persona02.class, 6);		// busca en la tabla persona02 el id 6
		if(p != null) {
			System.out.println(p.getApellidos() + " " + p.getNombre());
		}
		
		Persona02 nuevo = new Persona02();
		nuevo.setApellidos("Perez");
		nuevo.setApodo("Paco");
		nuevo.setDni("sin_papeles");
		nuevo.setNombre("No tiene");
		nuevo.setGenero(Genero.MASCULINO);
		
		// iniciar transaccion para commitear o rollbackear
		em.getTransaction().begin();
		// para "insertar" una nueva tabla en la base de datos
		em.persist(nuevo);
		// devuelve la transacción en curso, en este caso, begin
		em.getTransaction().commit();
		
		// importante cerrar para que, si hay fallos, no se quede ejecutando
		em.close();
		EMF.getEmf().close();
	}
}
