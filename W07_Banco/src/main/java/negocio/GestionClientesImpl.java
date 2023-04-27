package negocio;

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
}
