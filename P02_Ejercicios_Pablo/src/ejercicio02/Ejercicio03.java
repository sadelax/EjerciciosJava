package ejercicio02;

import util.Util;

//De una lista de n números ingresados por teclado, imprimir el mayor.

public class Ejercicio03 {
	public static void main(String[] arg) {
		int cant;
		double num, mayor;
		cant = Util.leerInt("Cantidad de números a procesar");
		num = Util.leerDouble("n");
		mayor = num;
		for (int i = 2; i <= cant; i++) {
			num = Util.leerDouble("n");
			if (num > mayor) {
				mayor = num;
			}
		}
		Util.mostrar("El mayor es " + mayor);
	}
}
