package agenda.persistencia;

import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;

public class ContactoDaoJPA implements ContactoDao {
	
	
	public ContactoDaoJPA() {
		
	}

	@Override
	public void insertar(Contacto c) {

	}

	@Override
	public boolean eliminar(int idContacto) {
		return true;
	}

	@Override
	public Contacto buscar(int idContacto) {
		Contacto encontrado = new Contacto();
		
		return encontrado;
	}

	@Override
	public void actualizar(Contacto contacto) {
		
	}

	@Override
	public Set<Contacto> buscar(String nom) {
		Set<Contacto> contactos = new TreeSet<>();
				
		return contactos;
	}
	
	@Override
	public Set<Contacto> buscarTodos() {
		Set<Contacto> contactos = new TreeSet<>();
				
		return contactos;
	}
	
}
