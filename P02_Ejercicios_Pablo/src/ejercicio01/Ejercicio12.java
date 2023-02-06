package ejercicio01;

import util.Util;

//12. Escribir un programa que lea de teclado dos tiempos expresados en horas, 
//  minutos y segundos; las sume y muestre el resultado en horas, minutos y segundos por pantalla.
public class Ejercicio12 {
	public static void main(String[] args) {
		int h1, m1, s1, h2, m2, s2, hs, mins, segs;
		Util.mostrar("Tiempo");
		h1 = Util.leerInt("Horas");
		m1 = Util.leerInt("Minutos");
		s1 = Util.leerInt("Segundos");

		h2 = Util.leerInt("Horas");
		m2 = Util.leerInt("Minutos");
		s2 = Util.leerInt("Segundos");

		segs = s1 + s2;
		mins = segs / 60;
		segs %= 60;
		
		mins += m1 + m2;
		hs = mins / 60 + h1 + h2;
		mins %= 60;
		
		Util.mostrar(hs + "h " + mins + "min " +  segs + "s");
	}
}
