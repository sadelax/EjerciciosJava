package agenda.negocio;

import agenda.modelo.Contacto;
import agenda.persistencia.ContactoDaoSimulado;

public class Agenda {
	
	private ContactoDaoSimulado cDao = new ContactoDaoSimulado();
		
	public void insertarContacto(Contacto c) {
		cDao.insertar(c);
	}
	
	public void borrar(int idContacto) {
		cDao.eliminar(idContacto);
	}
}
