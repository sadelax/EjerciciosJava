// Suma las areas totales.
package tests;

import modelo.Figura;
import modelo.Circulo;
import modelo.Rectangulo;
import modelo.Rombo;

public class Test3 {
	public static double sumaAreas(Figura[] ff) {
		double res = 0;
		for (int i = 0; i < ff.length; i++) {
			res += ff[i].area();
		}
		return res;
	}
	
	public static double unaDiagonalDeRombo(Figura[] ff) {
		double diag = 0;
		for (int i = 0; i < ff.length; i++) {
			if (ff[i] instanceof Rombo) {
				diag = ((Rombo)ff[i]).getD1();
			}
		}
		return diag;
	}
	
	public static void main(String[] args) {
		
		Figura[] figuras = {
				new Rectangulo(1, 2, 3, 4),
				new Rectangulo(1, 2, 3, 4),
				new Rectangulo(1, 2, 3, 4),
				new Rectangulo(1, 2, 3, 4),
				new Rectangulo(1, 2, 3, 4),
				new Circulo(1, 2, 3),
				new Circulo(4, 5, 6),
				new Circulo(9, 8, 7),
				new Rombo(4,6,1,3)
		};
		
		System.out.println(sumaAreas(figuras));
		System.out.println(unaDiagonalDeRombo(figuras));
	}
}
