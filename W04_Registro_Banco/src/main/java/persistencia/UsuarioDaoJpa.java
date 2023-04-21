package main.java.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import main.java.modelo.Usuario;
import main.java.util.EMF;


public class UsuarioDaoJpa implements UsuarioDao {
	
	EntityManager em;

	@Override
	public Usuario findById(Integer id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario valida(String usuario, String password) {
		em = EMF.getEmf().createEntityManager();
		Usuario u;
		String jpql = "SELECT u FROM Usuario u WHERE u.user = :usuario AND u.password = :pwd";
		TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
		q.setParameter("usuario", usuario);
		q.setParameter("pwd", password);
		try {
			u = q.getSingleResult();
		} catch (NoResultException e) {
			u = null;
		}
		em.close();
		return u;
	}

	@Override
	public boolean save(Usuario usuario) {
		em = EMF.getEmf().createEntityManager();
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
}
