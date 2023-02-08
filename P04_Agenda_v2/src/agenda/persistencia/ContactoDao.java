package agenda.persistencia;

import agenda.modelo.Contacto;

public interface ContactoDao {
	
	void insertar(Contacto c);

	boolean eliminar(int idContacto);
	
	Contacto buscar(int idContacto);

}
