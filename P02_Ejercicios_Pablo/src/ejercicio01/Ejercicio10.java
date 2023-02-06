package ejercicio01;

import util.Util;

//10.Hacer un algoritmo que permita obtener la cantidad de segundos en un tiempo dado 
//   en horas, minutos y segundos
public class Ejercicio10 {
	public static void main(String[] args) {
		int horas, minutos, segundos;
		Util.mostrar("Tiempo");
		horas = Util.leerInt("Horas");
		minutos = Util.leerInt("Minutos");
		segundos = Util.leerInt("Segundos");

		segundos = horas * 3600 + minutos * 60 + segundos;

		Util.mostrar("Segundos: " + segundos);
	}
}
