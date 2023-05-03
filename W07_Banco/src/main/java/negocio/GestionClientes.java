package negocio;

import java.util.List;
import java.util.Set;

import modelo.Cliente;

public interface GestionClientes extends GenericoNeg<Integer, Cliente>{

	// mostrar todos los clientes
	public Set<Cliente> findAllClientes();
	
	// mostrar cuentas por id
	public Cliente cuentasCliente(Integer id); 
	
	// buscar clientes
	List<Cliente> buscar(String valor);
	}
