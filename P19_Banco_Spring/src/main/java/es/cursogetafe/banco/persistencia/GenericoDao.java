package es.cursogetafe.banco.persistencia;

import java.util.Set;

public interface GenericoDao <K,E> {

	void save(E entidad);
	
	E findById(K id);
	
	E findbyIdEager(K id);
	
	Set<E> findAll();
	
	void delete(E entidad);
}
