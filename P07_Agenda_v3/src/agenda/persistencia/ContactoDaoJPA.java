package agenda.persistencia;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;

import agenda.config.Config;
import agenda.modelo.Contacto;

public class ContactoDaoJPA implements ContactoDao {
	
	private EntityManager em;

	@Override
	public void insertar(Contacto c) {
		em = Config.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public boolean eliminar(int idContacto) {
		em = Config.getEMF().createEntityManager();
		Contacto c = em.find(Contacto.class, idContacto);
		if (c == null) {
			em.close();
			return false;
		}
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public Contacto buscar(int idContacto) {
		em = Config.getEMF().createEntityManager();
		Contacto c = em.find(Contacto.class, idContacto);
		em.close();
		return c;
	}

	@Override
	public void actualizar(Contacto contacto) {
		em = Config.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.merge(contacto);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Set<Contacto> buscar(String nom) {
		// TODO
		Set<Contacto> contactos = new TreeSet<>();
				
		return contactos;
	}
	
	@Override
	public Set<Contacto> buscarTodos() {
		em = Config.getEMF().createEntityManager();
		String sql = "SELECT c FROM Contacto c";
		// TODO
		Set<Contacto> result = new TreeSet<>();
		
		return result;
	}
	
}
