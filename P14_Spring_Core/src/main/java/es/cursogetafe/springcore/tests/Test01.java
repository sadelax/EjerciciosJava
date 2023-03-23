package es.cursogetafe.springcore.tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursogetafe.springcore.clasesprueba.PersonaInterface;

public class Test01 {

	public static void main(String[] args) {
		
		// crear el contexto de Spring
		BeanFactory ctx = new ClassPathXmlApplicationContext("A01appCtx.xml");	// crea el classpath a partir de un xml, y búscalo en el classpath
		
		PersonaInterface p = ctx.getBean("unaPersona", PersonaInterface.class);
		
		p.setId(55);
		p.setNombre("peter");
		p.setTelefono("111111111");
		System.out.println(p);
		
		PersonaInterface otro = ctx.getBean("unaPersona", PersonaInterface.class);
		
		System.out.println(otro);
	}
}
