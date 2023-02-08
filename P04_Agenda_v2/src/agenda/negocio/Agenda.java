package agenda.negocio;

import agenda.modelo.Contacto;

public interface Agenda {
	
	void insertarContacto(Contacto c);
	
	void borrar(int idContacto);
}
