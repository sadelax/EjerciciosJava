package es.getafe.examen.negocio;

import java.util.Set;

import es.getafe.examen.modelo.Usuario;
import es.getafe.examen.persistencia.UsuarioDao;
import es.getafe.examen.persistencia.UsuarioDaoJPA;

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

	@Override
	public boolean eliminar(Usuario entidad) {
		// TODO Auto-generated method stub
		return false;
	}

}
