package agenda.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import agenda.persistencia.ContactoDao;
import agenda.persistencia.ContactoDaoMem;
import agenda.persistencia.ContactoDaoSerial;

public class Config {
	
	private static ContactoDao cDao;
	
	private static Properties prop;
	
	// aplicando el patrón Singleton para que mi método solo devuelva un objeto
	// véase que ContactoDao es una interfaz... EN REALIDAD engloba las clases que implementan ESTA INTERFAZ
		// (en este caso ContactoDaoSerial y ContactoDaoMem)
	public static ContactoDao getContactoDao() {
		if(cDao == null) {
			String tipoDao = getProperty("daos");
			switch (tipoDao) {
			case "mem":
				cDao = new ContactoDaoMem();
				break;
			case "serial":
				cDao = new ContactoDaoSerial();
				break;
			default:
				cDao = new ContactoDaoSerial();
				break;
			}			
		}
		return cDao;
	}
	
	// aplicando el patrón Singleton para que mi método solo devuelva un objeto
	private static Properties getProp() {
		if (prop == null) {
			prop = new Properties();
			// cargar el fichero
			try {
				prop.load(new FileReader("agenda.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		return prop;
	}
	
	public static String getProperty(String clave) {
		String valor = getProp().getProperty(clave);
		
		if(valor == null) valor = "";
		
		return valor;
	}
}
