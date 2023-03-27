package es.cursogetafe.banco.persistencia;

import java.util.TreeSet;

import es.cursogetafe.banco.modelo.Cliente;

public interface ClienteDao {

	void save(Cliente c);
	
	void findById(int idCliente);
	
	void deleteById(int idCliente);
	
	TreeSet<Cliente> findByNombre(String nom);
}
