package main.java.persistencia;

import main.java.modelo.Usuario;

public interface UsuarioDao{

	Usuario findById(Integer id);
	
	// Si no son validas, retorna null
	Usuario valida(String usuario, String password);
	
	boolean save(Usuario usuario);
}
