package persistencia;

import java.util.Set;

import modelo.Usuario;

public interface UsuarioDao{

	Usuario findById(Integer id);
	
	// Si no son validas, retorna null
	Usuario valida(String usuario, String password);
	
	boolean save(Usuario usuario);
	
	public Set<Usuario> findAll();
}
