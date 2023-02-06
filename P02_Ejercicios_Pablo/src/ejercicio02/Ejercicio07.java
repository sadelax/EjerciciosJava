package ejercicio02;

import util.Util;

//7. Dado un número entero n positivo, imprimir su factorial. 
//   0! = 1 1! = 1 2! = 2x1 = 2 3! = 3x2x1 = 6 4! = 4x3x2x1 = 24 5! = 120

public class Ejercicio07 {
	public static void main(String[] arg) {
		int num;
		double factorial = 1;
		Util.mostrar("Factorial de n");
		num = Util.leerInt("n");
		for (int i = 1; i <= num; i++) {
			factorial *= i; // factorial = factorial * i;
		}
		Util.mostrar("n! = " + factorial);
	}
}
