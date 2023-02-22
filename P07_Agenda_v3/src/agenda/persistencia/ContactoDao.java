package agenda.persistencia;

import java.util.Set;

import agenda.modelo.Contacto;

public interface ContactoDao {
	
	void insertar(Contacto c);

	boolean eliminar(int idContacto);
	
	Contacto buscar(int idContacto);

	void actualizar(Contacto contacto);
	
	// Debe retornar todos los contactos que nom aparezca en nombre, en apellidos o en el apodo
	Set<Contacto> buscar(String nom);
	
	Set<Contacto> buscarTodos();
}
