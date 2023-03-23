package agenda.persistencia;

import javax.persistence.EntityManager;

import agenda.config.Config;
import agenda.modelo.Contacto;

public class TestConexionJPA {

	public static void main(String[] args) {
		EntityManager em = Config.getEMF().createEntityManager();
		Contacto c = em.find(Contacto.class, 3);
		System.out.println(c);
		for(String telefono : c.getTelefonos()) {
			System.out.println(telefono);
		}
	}
}
