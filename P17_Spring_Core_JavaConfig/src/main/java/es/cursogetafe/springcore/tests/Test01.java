package es.cursogetafe.springcore.tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursogetafe.springcore.clasesprueba.PersonaInterface;
import es.cursogetafe.springcore.config.Config01;

public class Test01 {

	public static void main(String[] args) {
		
		// crear el contexto de Spring
		@SuppressWarnings("resource")
		BeanFactory ctx = new AnnotationConfigApplicationContext(Config01.class);
		
		PersonaInterface p = ctx.getBean("unaPersona", PersonaInterface.class);
		
		p.setId(55);
		p.setNombre("peter");
		p.setTelefono("111111111");
		System.out.println(p);
		
		PersonaInterface otro = ctx.getBean("unaPersona", PersonaInterface.class);
		
		System.out.println(otro);
	}
}
