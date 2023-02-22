package agenda.persistencia;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;

public class ContactoDaoMem implements ContactoDao {
	
	private Map<Integer, Contacto> almacen = new HashMap<>();
	private int id = 1;
	
	@Override
	public void insertar(Contacto c) {
		c.setIdContacto(id);
		almacen.put(id, c);
		id++;
	}

	@Override
	public boolean eliminar(int idContacto) {
		
		return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		
		return null;
	}

	@Override
	public void actualizar(Contacto contacto) {
		almacen.put(contacto.getIdContacto(), contacto);
	}

	@Override
	public Set<Contacto> buscar(String nom) {
		for (Contacto contacto : almacen.values()) {
			
		}
		
		return contacto;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		return new TreeSet<>(almacen.values());
	}
	
}
