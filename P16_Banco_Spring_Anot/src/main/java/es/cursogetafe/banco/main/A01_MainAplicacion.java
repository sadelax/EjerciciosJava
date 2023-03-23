package es.cursogetafe.banco.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursogetafe.banco.config.BancoConfig;

public class A01_MainAplicacion {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		new AnnotationConfigApplicationContext(BancoConfig.class);	
	}
}
