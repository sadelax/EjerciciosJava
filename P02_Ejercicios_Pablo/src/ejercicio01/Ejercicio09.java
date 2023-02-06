package ejercicio01;

import util.Util;

//Escribir un programa que convierta un valor dado en grados Fahrenheit a grados Celsius. 
// Fórmula para la conversión: F = 9/5C + 32

public class Ejercicio09 {
	public static void main(String[] args) {
		double farenheit, celsius;
		
		Util.mostrar("Convierte");
		farenheit= Util.leerDouble("numero 1");

		celsius = (farenheit - 32) * 5 / 9;
		
		Util.mostrar(farenheit + "ºF = " + celsius + "ºC");
	}
}
