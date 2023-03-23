package es.cursogetafe.banco.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:bbdd.properties")
@ComponentScan({"es.cursogetafe.banco.presentacion, es.cursogetafe.banco.negocio, es.cursogetafe.banco.persistencia"})
public class BancoConfig {
	
	@Autowired
	Environment prop;	// representa una clase property

	@Bean
	public DataSource dataSource() {
		
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(prop.getProperty("bbdd.driver"));
		bds.setUrl(prop.getProperty("bbdd.url"));
		bds.setUsername(prop.getProperty("bbdd.user"));
		bds.setPassword(prop.getProperty("bbdd.pass"));
		
		return bds;
	}
	
}
