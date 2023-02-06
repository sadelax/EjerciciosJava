package ejercicio02;

import util.Util;

//13. Escribir un programa que imprima por pantalla todas las fichas de dominó, 
//  de una por línea y sin repetir. 
//  0 : 0 
//  0 : 1 
//  …

public class Ejercicio13a {
	public static void main(String[] arg) {
		Util.mostrar("Fichas Dominó");

		for (int i = 0; i <= 6; i++) {
			for (int j = i; j <= 6; j++) {
				Util.mostrar(i + " | " + j);
			}
			System.out.println();
		}
	}
}
