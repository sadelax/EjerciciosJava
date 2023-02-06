package ejercicio02;

import util.Util;

//13. Escribir un programa que imprima por pantalla todas las fichas de dominó, 
//  de una por línea y sin repetir. 
//  0 : 0 
//  0 : 1 
//  …

public class Ejercicio13 {
	public static void main(String[] arg) {
		Util.mostrar("Fichas Dominó");

		for (int i = 0; i <= 6; i++) {
			for (int j = i; j <= 6; j++) {
				Util.mostrar("\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510");
				Util.mostrar("\u2502 " + i + " \u2502 " + j + " \u2502");
				Util.mostrar("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518");
			}
		}
	}
}
