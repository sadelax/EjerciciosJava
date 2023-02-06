package ejercicio01;

import util.Util;

//11. Hacer un algoritmo que permita Obtener la cantidad de horas, 
//  minutos y segundos de un tiempo dado en segundos. 
public class Ejercicio11 {
	public static void main(String[] args) {
		int horas, minutos, segundos;
		Util.mostrar("Tiempo");
		segundos = Util.leerInt("Segundos");

		horas = segundos / 3600;
		segundos %= 3600;
		minutos = segundos / 60;
		segundos %= 60;

		Util.mostrar(horas + "h " + minutos + "min " +  segundos + "s");
	}
}
