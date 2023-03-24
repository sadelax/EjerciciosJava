package es.cursogetafe.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.cursogetafe.springcore.clasesprueba.Familia;
import es.cursogetafe.springcore.clasesprueba.Persona;

@Configuration
public class Config04b {

	@Bean
	public Persona madre() {
		return new Persona(444, "Maria", "444444444");
	}
	
	@Bean
	public Persona padre() {
		return new Persona(555, "Pedro", "123123123");
	}
	
	@Bean
	@Scope("prototype")
	public Familia unaFamilia(Persona madre, Persona padre) {
		Familia f = new Familia();
		f.setMadre(madre);
		f.setPadre(padre);
		return f;
	}
	
}
