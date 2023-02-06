package ejercicio02;

import util.Util;

//Imprimir por pantalla los números 1 hasta un número ingresado por teclado.

public class Ejercicio01_ii_For {
	public static void main(String[] arg) {
		int cant;
		cant = Util.leerInt("Hasta que numero necesitas");
		
		for (int i = 1; i <= cant; i++) {
			Util.mostrarSinSalto(i + ", ");
		}
	}
}
