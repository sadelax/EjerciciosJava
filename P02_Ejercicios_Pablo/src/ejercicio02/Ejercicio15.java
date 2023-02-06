package ejercicio02;

import util.Util;

//15. Escriba un programa que pida un número entero mayor que cero y que escriba 
//   sus divisores.
public class Ejercicio15 {
	public static void main(String[] arg) {
		Util.mostrar("Divisores de n");
		int n;
		do {
			n = Util.leerInt("n (>0)");
		} while(n <= 0);
		
		for (int i = 1; i <= n/2; i++) {
			if (n % i == 0) {
				Util.mostrarSinSalto(i + ", ");
			}
		}
		Util.mostrar(n);
	}
}
