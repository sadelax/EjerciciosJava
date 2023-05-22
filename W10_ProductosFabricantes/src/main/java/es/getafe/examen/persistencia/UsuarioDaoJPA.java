package es.getafe.examen.persistencia;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import at.favre.lib.crypto.bcrypt.BCrypt;
import es.getafe.examen.modelo.Usuario;
import util.EMF;

public class UsuarioDaoJPA implements UsuarioDao {
	
	EntityManager em;

	@Override
	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario valida(String usuario, String password) {
		em = EMF.getEmf().createEntityManager();
		Usuario u;
		String jpql = "SELECT u FROM Usuario u WHERE u.username = :usuario";
		TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
		q.setParameter("usuario", usuario);
		try {
			u = q.getSingleResult();
			if(!BCrypt.verifyer().verify(password.toCharArray(), u.getPassword()).verified) {
				u = null;
			}
		} catch (NoResultException e) {
			u = null;
		}
		em.close();
		return u;
	}

	@Override
	public boolean save(Usuario usuario) {
		em = EMF.getEmf().createEntityManager();
		
		char[] clave = BCrypt.withDefaults().hashToChar(12, usuario.getPassword().toCharArray());
		String pwdEnc = String.valueOf(clave);
		usuario.setPassword(pwdEnc);
		
		try {
			em.getTransaction().begin();
			em.merge(usuario);				
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Set<Usuario> findAll() {
		String jpql = "SELECT u FROM Usuario u";
		em = EMF.getEmf().createEntityManager();
		TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
		Set<Usuario> resu = new TreeSet<>(q.getResultList());
		em.close();
		return resu;
	}

}
