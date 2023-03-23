package es.cursogetafe.springcore.clasesprueba;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FactoriaDeCalendarios {
	public static CalendarioInterface createCalendarioActual() {
		System.out.println("Creando calendario en la factor�a");
		String mes = (new SimpleDateFormat("MMMM")).format(new Date());
		Calendario cal = new Calendario();
		cal.setPrimero(new Dia(1, mes));
		cal.setUltimo(new Dia(31, mes));
		cal.setEntrada("Mes Actual");
		return cal;
	}
}
