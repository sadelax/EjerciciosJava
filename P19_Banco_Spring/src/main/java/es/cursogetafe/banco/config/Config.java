package es.cursogetafe.banco.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"es.cursogetafe.banco.vista", "es.cursogetafe.banco.negocio", "es.cursogetafe.banco.persistencia"})
public class Config {

	@Bean("emf")
	public EntityManagerFactory emf() {
		return Persistence.createEntityManagerFactory("Banco_Spring");
	}
}
