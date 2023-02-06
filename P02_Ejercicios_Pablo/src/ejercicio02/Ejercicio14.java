package ejercicio02;

import util.Util;

//14. Escribir un programa que pida al usuario un número entero positivo y 
//   muestre por pantalla la cuenta atrás desde ese número hasta cero separados por comas.

public class Ejercicio14 {
	public static void main(String[] arg) {
		Util.mostrar("Cuenta atrás");

		int n = Util.leerInt("n");
		
		for (int i = n; i >= 0; i--) {
			Util.mostrarSinSalto(i + ", ");
		}
	}
}
