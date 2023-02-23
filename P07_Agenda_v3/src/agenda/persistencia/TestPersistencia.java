package agenda.persistencia;

import agenda.modelo.Contacto;

public class TestPersistencia {
	public static void main(String[] args) {
		Contacto c1 = new Contacto("Amancio", "ortega", "Poca Pasta");
		Contacto c2 = new Contacto("Pedro", "peta", "Zeta");
		Contacto c3 = new Contacto("Mario", "diMaria", "Alfa");
		
		ContactoDaoMem contacto = new ContactoDaoMem();
		
		contacto.insertar(c1);
		contacto.insertar(c2);
		contacto.insertar(c3);
		
		System.out.println(contacto.buscar("Aman"));
		
		System.out.println(contacto.buscarTodos());
	}
}
