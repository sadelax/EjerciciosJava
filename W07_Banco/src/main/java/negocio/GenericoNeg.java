package negocio;

public interface GenericoNeg <K,E>{

	// registrar nuevos usuarios/clientes a la bbdd
	public boolean registro(E entidad);
	
	// eliminar usuarios/clientes de la bbdd
	public boolean eliminar(E entidad);
}
