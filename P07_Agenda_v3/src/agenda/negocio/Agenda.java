package agenda.negocio;

import java.util.Set;

import agenda.modelo.Contacto;

public interface Agenda {
	
	void insertarContacto(Contacto c);
	
	Contacto eliminar(int idContacto);
	
	boolean eliminar(Contacto c);
	
	public void modificar(Contacto c);
	
	// Debe retornar los contactos ordenados por apodo
	public Set<Contacto> buscarTodos();
}
