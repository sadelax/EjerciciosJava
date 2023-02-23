package agenda.persistencia;

import java.util.HashMap;
import java.util.HashSet;
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
		Contacto c = new Contacto();
		c = almacen.remove(idContacto);
		if(c != null) return true;
		else return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		return almacen.get(idContacto);
	}

	@Override
	public void actualizar(Contacto contacto) {
		almacen.put(contacto.getIdContacto(), contacto);
	}

	@Override
	public Set<Contacto> buscar(String nom) {
		Set<Contacto> c = new HashSet<>();
		nom = nom.toLowerCase();
		for (Contacto iContacto : almacen.values()) {
			if (
				(iContacto.getNombre().toLowerCase().indexOf(nom) != -1) || 
				(iContacto.getApellidos().toLowerCase().indexOf(nom) != -1) ||
				(iContacto.getApodo().toLowerCase().indexOf(nom) != -1)) {
					c.add(iContacto);
			}
		}
		return c;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		return new TreeSet<>(almacen.values());
	}
	
}
