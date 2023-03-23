package es.cursogetafe.springcore.tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.cursogetafe.springcore.clasesprueba.Familia;

public class Test04 {

	public static void main(String[] args) {
		
		// crear el contexto de Spring
		@SuppressWarnings("resource")
		BeanFactory ctx = new ClassPathXmlApplicationContext("A04appCtx.xml");	// crea el classpath a partir de un xml, y búscalo en el classpath
		
		Familia f = ctx.getBean("unaFamilia", Familia.class); // lo suyo sería q la ref fuese del tipo interface pero bueno
		
		System.out.println(f);
		
		System.out.println(f.getDias());
	}
}
