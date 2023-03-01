package agenda.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;

public class ContactoDaoSerial implements ContactoDao {

	private Almacen almacen;
	private final String NOMBRE_FICHERO = "agenda.dat";
	
	public ContactoDaoSerial() throws RuntimeException {
		try(FileInputStream fis = new FileInputStream(NOMBRE_FICHERO)){
			ObjectInputStream ois = new ObjectInputStream(fis); // "quiero q me de-serializes objetos de fis"
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
			ObjectOutputStream oos = new ObjectOutputStream(fos);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Contacto contacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Contacto> buscar(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscarTodos() {
		return new TreeSet<>(almacen.mapa.values());
	}
	
}
