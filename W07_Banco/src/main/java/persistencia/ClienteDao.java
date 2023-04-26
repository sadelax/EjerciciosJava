package persistencia;

import java.util.List;

import modelo.Cliente;

public interface ClienteDao extends GenericoDao<Integer, Cliente> {

	List<Cliente> findByValue(String valor);
	
}
