package ejercicio02;

import util.Util;

//16. Escribir un programa que pida al usuario un número entero positivo mayor que 2 
//  y muestre por pantalla si es un número primo o no.
public class Ejercicio16 {
	public static void main(String[] arg) {
		Util.mostrar("n es Primo?");
		int n;
		do {
			n = Util.leerInt("n (>2)");
		} while(n <= 2);
		
		int raizN = (int)Math.sqrt(n);
		
		boolean esPrimo;

//		if (n%2==0 || n%3==0 || n%5==0 || n%7==0 || n%11==0) {
//			esPrimo = false;
//		} else {
//			esPrimo = true;
//		}
		
		esPrimo = !(n%2==0 || n%3==0 || n%5==0 || n%7==0 || n%11==0);
		
		if(esPrimo) {
			for (int i = 13; i <= raizN && !esPrimo; i=i+2) {
				if (n % i == 0) esPrimo = false;
			}
		}

		Util.mostrar(esPrimo?"Es primo":"No es primo");
	}
}
