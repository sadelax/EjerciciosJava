package es.cursogetafe.banco.persistencia;

import es.cursogetafe.banco.modelo.Cuenta;
import es.cursogetafe.banco.modelo.Extracto;

public interface ExtractoDao extends GenericoDao<Integer, Extracto> {
	
	public Extracto extractoFechaEager(Cuenta c, int anyo, int mes);

}
