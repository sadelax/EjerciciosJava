package ejercicio01;

import util.Util;

//Hacer un programa que Dado un año indicar si es bisiesto. Un año es bisiesto si 
//  es un número divisible por 4, 
//  pero si es divisible por 100 debe ser es divisible por 400.

public class Ejercicio14 {
	public static void main(String[] args) {
		int anyo;
		
		Util.mostrar("Bisiesto");
		anyo = Util.leerInt("Ingrese año");
		
		boolean esBisiesto = false;
		
		if (anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0)) {
			esBisiesto = true;
		}
		
		System.out.println("El año " + anyo + " " + (esBisiesto ? "SI" : "NO") + " es bisiesto.");
	}
}
