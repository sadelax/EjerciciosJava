package ejercicio02;

import util.Util;

//Imprimir la suma de n números ingresados por teclado. La cantidad de números 
//  (n) se solicita al usuario al principio y se ingresa por teclado.

public class Ejercicio01a {
	public static void main(String[] arg) {
		int cant;
		double num, sum = 0;
		cant = Util.leerInt("Cantidad de números a procesar");
		for (int i = 1; i <= cant; i++) {
			num = Util.leerDouble("n");
			sum += num;
		}
		Util.mostrar("\u03A3=" + sum);
	}
}
