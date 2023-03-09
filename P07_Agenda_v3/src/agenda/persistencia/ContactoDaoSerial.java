package agenda.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
	
	// para guardar el fichero de bits de nuevo en un CSV, junto con el main para lanzarlo
	public void guardarContactosCSV(String nombreFichero) throws IOException {
	    try (FileInputStream fis = new FileInputStream(NOMBRE_FICHERO)) {
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        Almacen almacen = (Almacen) ois.readObject();
	        
	        FileWriter fw = new FileWriter(nombreFichero);
	        PrintWriter pw = new PrintWriter(fw);
	        
	        pw.println("nombre,apellido,email,telefono");
	        
	        for (Contacto contacto : almacen.mapa.values()) {
	            pw.println(contacto.getNombre() + "," + 
	            			contacto.getApellidos() + "," + 
	            			contacto.getApodo() + "," + 
	            			contacto.getDom().getTipoVia() + "," +
	            			contacto.getDom().getVia() + "," +
	            			contacto.getDom().getNumero() + "," +
	            			contacto.getDom().getPiso() + "," +
	            			contacto.getDom().getPuerta() + "," +
	            			contacto.getDom().getCodigoPostal() + "," +
	            			contacto.getDom().getCiudad() + "," +
	            			contacto.getDom().getProvincia() + "," +
	            			contacto.getTelefonos()+ "," +
	            			contacto.getCorreos());
	        }
	        
	        pw.close();
	        fw.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException();
	    }
	}
	
	public static void main(String[] args) {
		ContactoDaoSerial dao = new ContactoDaoSerial();
		try {
			dao.guardarContactosCSV("contactosPrueba.csv");
	        System.out.println("Los contactos se han guardado correctamente en el archivo contactosPrueba.csv.");
	        } catch (IOException e) {
	        	System.err.println("Ha ocurrido un error al guardar los contactos en el archivo CSV.");
	        	e.printStackTrace();
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
