package es.cursogetafe.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.cursogetafe.springcore.clasesprueba.Familia;
import es.cursogetafe.springcore.clasesprueba.Persona;

@Configuration
public class Config04 {

	@Bean
	public Persona getMadre() {
		return new Persona(444, "Maria", "444444444");
	}
	
	@Bean
	public Persona getPadre() {
		return new Persona(555, "Pedro", "123123123");
	}
	
	@Bean
	@Scope("prototype")
	public Familia unaFamilia() {
		Familia f = new Familia();
		f.setMadre(getMadre());
		f.setPadre(getPadre());
		return f;
	}
	
}
