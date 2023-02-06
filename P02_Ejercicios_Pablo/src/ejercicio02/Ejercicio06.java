package ejercicio02;

import util.Util;

//6. Siguiendo la misma metodología de carga, calcular 
//  la cantidad de valores >= 0 y la cantidad menores que 0.

public class Ejercicio06 {
	public static void main(String[] arg) {
		int cant, cantPos = 0, cantNeg;
		double num;
		cant = Util.leerInt("Cantidad de números a procesar");
		for (int i = 1; i <= cant; i++) {
			num = Util.leerDouble("n");
			if (num >= 0) cantPos++;
		}
		cantNeg = cant - cantPos;
		Util.mostrar("Ha ingresado " + cantPos + " números positivos.");
		Util.mostrar("y " + cantNeg + " números negativos.");
	}
}
