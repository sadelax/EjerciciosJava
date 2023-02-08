package agenda.persistencia;

import agenda.modelo.Contacto;

public class ContactoDaoSimulado {

	public void insertar(Contacto c) {
		System.out.println("se ha insertado " + c);
	}
	
	public boolean eliminar(int idContacto) {
		System.out.println("se ha eliminado " + idContacto);
		return true;
	}
	
	public Contacto buscar(int idContacto) {
		Contacto c = new Contacto();
		c.setIdContacto(idContacto);
		c.setNombre("Jose");
		c.setApodo("Pepe");
		return c;
	}
		
}
