package es.cursogetafe.banco.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A01_MainAplicacion {
	public static void main(String[] args) {
		
		// gracias a lo siguiente ya sabemos q se está cargando spring
		@SuppressWarnings("resource")
		BeanFactory ctx = new ClassPathXmlApplicationContext("bancoCtx.xml");		
	}
}
