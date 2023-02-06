package ejercicio02;

import util.Util;

//10. Dado un número entero n, imprimir su tabla de multiplicar del 1 al 9.

public class Ejercicio10 {
	public static void main(String[] arg) {
		int num;
		Util.mostrar("Tabla de multiplicar");
		num = Util.leerInt("n");

		for (int i = 0; i <= 9; i++) {
			Util.mostrar(num + " x " + i + " = " + (i*num));
		}
	}
}
