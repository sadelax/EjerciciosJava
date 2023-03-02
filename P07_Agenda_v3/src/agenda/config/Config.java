package agenda.config;

import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoSerial;

public class Config {
	
	// aplicando el patrón Singleton para que mi método solo devuelva un objeto
	private static ContactoDao cDao;
	
	public static ContactoDao getContactoDao() {
		if(cDao == null) {
			cDao = new ContactoDaoSerial();
		}
		return cDao;
	}
}
