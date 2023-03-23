package es.cursogetafe.banco.persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public abstract class MyDataSource {

	private static BasicDataSource ds;
	
	private MyDataSource(){}
	
	public static BasicDataSource getDataSource(){
		if (ds == null) {
			ds = new BasicDataSource();
			Properties prop = new Properties();
			try {
				prop.load(new FileReader("src/bbdd.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			ds.setDriverClassName(prop.getProperty("bbdd.driver"));
			ds.setUrl(prop.getProperty("bbdd.url"));
		
			ds.setUsername(prop.getProperty("bbdd.user"));
			ds.setPassword(prop.getProperty("bbdd.pass"));
		}
		return ds;
	}
}
