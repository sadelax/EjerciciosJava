package agenda.negocio;

import agenda.modelo.Contacto;
import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoSQL;
//import agenda.persistencia.ContactoDaoSimulado;

public class AgendaImpl implements Agenda{
	
//	private ContactoDao cDao = new ContactoDaoSimulado();
	private ContactoDao cDao = new ContactoDaoSQL();
		
	public void insertarContacto(Contacto c) {
		cDao.insertar(c);
	}
	
	public void borrar(int idContacto) {
		cDao.eliminar(idContacto);
	}
}
