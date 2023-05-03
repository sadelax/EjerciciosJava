package negocio;

import java.util.List;
import java.util.Set;

import modelo.Cliente;
import persistencia.ClienteDao;
import persistencia.ClienteDaoJPA;

public class GestionClientesImpl implements GestionClientes {
	
	private ClienteDao clid = new ClienteDaoJPA();

	@Override
	public Set<Cliente> findAllClientes() {
		return clid.findAll();
	}

	@Override
	public Cliente cuentasCliente(Integer id) {
		return clid.findByIdEager(id);
	}

	@Override
	public boolean registro(Cliente entidad) {
		if (entidad != null) {
			clid.save(entidad);
			System.out.println(entidad);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Cliente> buscar(String valor) {
		return clid.findByValue(valor);
	}
}
