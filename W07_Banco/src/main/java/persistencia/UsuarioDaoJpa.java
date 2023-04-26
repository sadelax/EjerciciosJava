package persistencia;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import modelo.Cuenta;
import modelo.Usuario;
import util.EMF;

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
		String jpql = "SELECT u FROM Usuario u WHERE u.username = :usuario AND u.password = :pwd";
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
