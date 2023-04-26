package persistencia;

import java.util.List;

import modelo.Tarjeta;

public interface TarjetaDao extends GenericoDao<Integer, Tarjeta> {

	List<Tarjeta> vigentes(Tarjeta tarjeta);
}
