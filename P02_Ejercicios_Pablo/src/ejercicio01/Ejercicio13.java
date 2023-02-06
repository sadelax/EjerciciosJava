package ejercicio01;

import util.Util;

//13. Hacer un programa que dado un número entero n, indica si es o no par.

public class Ejercicio13 {
	public static void main(String[] args) {
		int num;
		
		Util.mostrar("Pares");
		num = Util.leerInt("Ingrese num");
		
		Util.mostrar(num + " es " + (num % 2 == 0 ? "par." : "impar."));
	}
}
