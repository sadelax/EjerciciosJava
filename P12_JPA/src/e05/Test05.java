package e05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test05 {
	public static void main(String[] args) {
		// equivalente al datasource
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebasJPA"); // le pasamos el nombre de la unidad de persistencia
		
		// equivalente a connection + prep statement
		EntityManager em = emf.createEntityManager();
		
		Persona05 nuevo = new Persona05();
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
