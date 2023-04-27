package negocio;

import java.util.Set;

import modelo.Usuario;
import persistencia.UsuarioDao;
import persistencia.UsuarioDaoJPA;

public class GestionUsuariosImpl implements GestionUsuarios {
	
	private UsuarioDao ud = new UsuarioDaoJPA();

	@Override
	public Usuario existe(String usuario, String password) {
		return ud.valida(usuario, password);
	}

	@Override
	public boolean registro(Usuario usuario) {
		return ud.save(usuario);
	}

	@Override
	public Set<Usuario> findAllUsuarios() {
		return ud.findAll();
	}

}
