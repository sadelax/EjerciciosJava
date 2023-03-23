package es.cursogetafe.springcore.tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.cursogetafe.springcore.clasesprueba.Familia;
import es.cursogetafe.springcore.config.Config04;

public class Test04 {

	public static void main(String[] args) {
		
		// crear el contexto de Spring
		@SuppressWarnings("resource")
		BeanFactory ctx = new AnnotationConfigApplicationContext(Config04.class);
		
		Familia f = ctx.getBean("unaFamilia", Familia.class);
		System.out.println(f);
		
		Familia f2 = ctx.getBean("unaFamilia", Familia.class);
	}
}
