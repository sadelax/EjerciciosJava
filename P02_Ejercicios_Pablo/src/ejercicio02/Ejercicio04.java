package ejercicio02;

import util.Util;

//4. De una lista de n números ingresados por teclado, imprimir el mayor y el menor valor.

public class Ejercicio04 {
	public static void main(String[] arg) {
		int cant;
		double num, mayor, menor;
		cant = Util.leerInt("Cantidad de números a procesar");
		num = Util.leerDouble("n");
		menor = mayor = num;
		for (int i = 2; i <= cant; i++) {
			num = Util.leerDouble("n");
			if (num > mayor) {
				mayor = num;
			} else if(num < menor) {
				menor = num;
			}
		}
		Util.mostrar("El mayor es " + mayor);
		Util.mostrar("El menor es " + menor);
	}
}
