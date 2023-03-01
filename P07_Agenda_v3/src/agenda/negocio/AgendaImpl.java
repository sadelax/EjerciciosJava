package agenda.negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import agenda.modelo.Contacto;
import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoSerial;

public class AgendaImpl implements Agenda{

	private ContactoDao dao = new ContactoDaoSerial();
	
	@Override
	public void insertarContacto(Contacto c) {
		dao.insertar(c);
	}

	@Override
	public Contacto eliminar(int idContacto) {
		Contacto c = dao.buscar(idContacto);
		dao.eliminar(idContacto);
		return c;
	}

	@Override
	public boolean eliminar(Contacto c) {
		return dao.eliminar(c.getIdContacto());
	}

	@Override
	public void modificar(Contacto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Contacto> buscarTodos() {
		return dao.buscarTodos();
	}

	@Override
	public Set<Contacto> buscarContactoPorNombre(String nombre) {
		return dao.buscar(nombre);
	}

	@Override
	public int importarCSV(String fichero) throws IOException {

		List<String> csv = leerFichero(fichero);
		for(String linea : csv) {
			String[] datos = linea.split(";");
			Contacto nuevo = creaContacto(datos);
			dao.insertar(nuevo);
		}
		return csv.size();
	}

	private List<String> leerFichero(String fichero) throws IOException {
		List<String> datos = new LinkedList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
			String linea;
			while((linea = br.readLine()) != null) {
				datos.add(linea);
			}
		}
	
		return datos;
	}

	private Contacto creaContacto(String[] datos) {
		Contacto c = new Contacto();
		c.setNombre(datos[0]);
		c.setApellidos(datos[1]);
		c.setApodo(datos[2]);
		c.getDom().setTipoVia(datos[3]);
		c.getDom().setVia(datos[4]);
		c.getDom().setNumero(Integer.parseInt(datos[5]));
		c.getDom().setPiso(Integer.parseInt(datos[6]));
		c.getDom().setPuerta(datos[7]);
		c.getDom().setCodigoPostal(datos[8]);
		c.getDom().setProvincia(datos[9]);
		c.getDom().setCiudad(datos[10]);
		c.addTelefonos(datos[11].split("/"));
		c.addCorreos(datos[12].split("/"));

		return c;
	}
	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		String fichero = "Blaze;Arsenio Holloway;a,;Plaza;429-5439 Ligula. Rd.;21BIS;10;F;79344;Alcobendas;Madrid;609416957/609224648;jcardozo@gmail.com/dapibus@egestas.co.uk";
//		String[] datos = fichero.split(";");
//		for(int i = 0; i < datos.length; i++) {
//			System.out.println(i + " " + datos[i]);
//		}
//	}
}


