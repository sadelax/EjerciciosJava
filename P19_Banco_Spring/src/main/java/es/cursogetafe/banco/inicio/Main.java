package es.cursogetafe.banco.inicio;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursogetafe.banco.config.Config;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		new AnnotationConfigApplicationContext(Config.class);
	}
}
