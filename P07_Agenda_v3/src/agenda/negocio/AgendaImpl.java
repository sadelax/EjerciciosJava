package agenda.negocio;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import agenda.modelo.Contacto;
import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoMem;

public class AgendaImpl implements Agenda{

	private ContactoDao dao = new ContactoDaoMem();
	
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
		
		return 0;
	}

	private List<String> leerFichero(String fichero) throws IOException {

		return null;
	}

}
