package es.cursogetafe.banco.persistencia;

import java.util.List;

import es.cursogetafe.banco.modelo.Cliente;

public interface ClienteDao extends GenericoDao<Integer, Cliente> {

	List<Cliente> findByValue(String valor);
	
}
