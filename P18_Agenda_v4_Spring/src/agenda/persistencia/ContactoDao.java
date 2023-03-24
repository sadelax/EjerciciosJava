package agenda.persistencia;

import java.util.Set;

import agenda.modelo.Contacto;

public interface ContactoDao {
	
	void save(Contacto c);

	void delete(int idContacto);
	
	// debe retornar el Contacto e modo Eager
	Contacto findByIdEager(int idContacto);
	
	// Debe retornar todos los contactos que nom aparezca en nombre, en apellidos o en el apodo
	Set<Contacto> findByValue(String nom);
	
	Set<Contacto> findAll();
}
