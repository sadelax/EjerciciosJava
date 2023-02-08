package agenda.persistencia;

import agenda.modelo.Contacto;

public class ContactoDaoSQL implements ContactoDao {

	@Override
	public void insertar(Contacto c) {
		System.out.println("insert into contactos ...");
		System.out.println(c + " se ha guardado en Mysql");
		
	}

	@Override
	public boolean eliminar(int idContacto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
