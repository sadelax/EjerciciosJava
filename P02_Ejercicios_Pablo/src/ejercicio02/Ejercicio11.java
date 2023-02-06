package ejercicio02;

import util.Util;

//11. Escribir un programa que imprima las tablas del 1 al 9.

public class Ejercicio11 {
	public static void main(String[] arg) {
		Util.mostrar("Tablas de multiplicar");

		for (int i = 1; i <= 9; i++) {
			Util.mostrar("\nTabla del " + i);
			for (int j = 0; j <= 9; j++) {
				Util.mostrar(i + " x " + j + " = " + (i*j));
			}
		}
	}
}
