package agenda.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;

public class ContactoDaoSerial implements ContactoDao {

	private Almacen almacen;
	private final String NOMBRE_FICHERO = "agenda.dat";
	
	public ContactoDaoSerial() throws RuntimeException {
		try(FileInputStream fis = new FileInputStream(NOMBRE_FICHERO)){
			// "quiero q me de-serializes objetos de fis":
			// "o más bien, convierte la ristra de bits de fis, a objeto ois":
			ObjectInputStream ois = new ObjectInputStream(fis);
			// guardo el objeto ois en almacén (lo (down)casteo para q sea compatible con el tipo)
			almacen = (Almacen)ois.readObject();
			
		} catch (FileNotFoundException e) {
			almacen = new Almacen();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	private void grabarAlmacen() throws RuntimeException {
		try(FileOutputStream fos = new FileOutputStream(NOMBRE_FICHERO)){
			// "quiero q me serializes objetos de fis":
			// convierte la ristra de bits del fichero a un objeto...
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// ... y SERIALÍZALO:
			oos.writeObject(almacen);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	@Override
	public void insertar(Contacto c) {
		c.setIdContacto(almacen.autoIncrement);
		almacen.mapa.put(almacen.autoIncrement++, c);
		grabarAlmacen();
	}

	@Override
	public boolean eliminar(int idContacto) {
		Contacto c = new Contacto();
		c = almacen.mapa.remove(idContacto);
		if (c != null) return true;
		else return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		return almacen.mapa.get(idContacto);
	}

	@Override
	public void actualizar(Contacto contacto) {
		almacen.mapa.put(contacto.getIdContacto(), contacto);
	}

	@Override
	public Set<Contacto> buscar(String nom) {
		Set<Contacto> c = new HashSet<>();
		nom = nom.toLowerCase();
		
		for (Contacto contacto : almacen.mapa.values()) {
			if(
				(contacto.getNombre().toLowerCase().indexOf(nom) != -1) ||
				(contacto.getApellidos().toLowerCase().indexOf(nom) != -1) ||
				(contacto.getApodo().toLowerCase().indexOf(nom) != -1)) {
					c.add(contacto);
			}
		}
		return c;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		return new TreeSet<>(almacen.mapa.values());
	}
	
}
