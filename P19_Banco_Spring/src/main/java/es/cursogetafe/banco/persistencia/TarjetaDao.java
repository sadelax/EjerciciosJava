package es.cursogetafe.banco.persistencia;

import java.util.List;

import es.cursogetafe.banco.modelo.Tarjeta;

public interface TarjetaDao extends GenericoDao<Integer, Tarjeta> {

	List<Tarjeta> vigentes(Tarjeta tarjeta);
}
