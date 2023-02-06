package ejercicio02;

import util.Util;

//5. Siguiendo la misma metodología de carga, calcular la cantidad de valores positivos.

public class Ejercicio05 {
	public static void main(String[] arg) {
		int cant, cantPos = 0;
		double num;
		cant = Util.leerInt("Cantidad de números a procesar");
		for (int i = 1; i <= cant; i++) {
			num = Util.leerDouble("n");
			if (num > 0) cantPos++;
		}
		Util.mostrar("Ha ingresado " + cantPos + " números positivos.");
	}
}
