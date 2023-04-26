package persistencia;

import modelo.Cuenta;
import modelo.Extracto;

public interface ExtractoDao extends GenericoDao<Integer, Extracto> {
	
	public Extracto extractoFechaEager(Cuenta c, int anyo, int mes);

}
