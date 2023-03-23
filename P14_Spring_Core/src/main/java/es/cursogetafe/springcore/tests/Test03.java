package es.cursogetafe.springcore.tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursogetafe.springcore.clasesprueba.PersonaInterface;

public class Test03 {

	public static void main(String[] args) {
		
		// crear el contexto de Spring
		@SuppressWarnings("resource")
		BeanFactory ctx = new ClassPathXmlApplicationContext("A03appCtx.xml");	// crea el classpath a partir de un xml, y búscalo en el classpath
		
		PersonaInterface p = ctx.getBean("unaPersona", PersonaInterface.class);
				
		System.out.println(p);
	}
}
