package es.cursogetafe.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.cursogetafe.springcore.clasesprueba.Persona;
import es.cursogetafe.springcore.clasesprueba.PersonaInterface;

@Configuration
public class Config01 {

	@Bean
//	@Scope("prototype") --- esto es para que no sea singleton jajaja
	public PersonaInterface unaPersona() {
		return new Persona();
	}
	
}
