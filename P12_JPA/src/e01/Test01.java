package e01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test01 {
	public static void main(String[] args) {
		// equivalente al datasource
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebasJPA"); // le pasamos el nombre de la unidad de persistencia
		
		// equivalente a connection + prep statement
		EntityManager em = emf.createEntityManager();
		
		Persona p = em.find(Persona.class, 12);
		if(p != null) {
			System.out.println(p.getApellidos() + " " + p.getApodo());
		}
		
		Persona nuevo = new Persona();
		nuevo.setApellidos("Perez");
		nuevo.setApodo("Paco");
		nuevo.setDni("sin_papeles");
		nuevo.setNombre("No tiene");
		
		// iniciar transaccion para commitear o rollbackear
		em.getTransaction().begin();
		// para "insertar" una nueva tabla en la base de datos
		em.persist(nuevo);
		// devuelve la transacción en curso, en este caso, begin
		em.getTransaction().commit();
		
		// importante cerrar para que, si hay fallos, no se quede ejecutando
		em.close();
		emf.close();
	}
}
