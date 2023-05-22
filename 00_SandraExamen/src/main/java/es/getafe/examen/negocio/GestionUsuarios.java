package es.getafe.examen.negocio;

import java.util.Set;

import es.getafe.examen.modelo.Usuario;

public interface GestionUsuarios extends GenericoNeg<Integer, Usuario>{

	// recuperar de la bbdd el usuario y la contraseña
	// deberá retornar el Usuario
	public Usuario existe(String usuario, String password);
	
	// registrar nuevos usuarios a la bbdd
	public boolean registro(Usuario usuario);
	
	// mostrar usuarios registrados
	public Set<Usuario> findAllUsuarios();
	
}
