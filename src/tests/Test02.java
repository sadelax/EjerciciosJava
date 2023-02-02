// Suma las areas totales.
package tests;

import modelo.Circulo;
import modelo.Rectangulo;

public class Test02 {
	public static double sumaAreas(Rectangulo[] rr, Circulo[] cc) {
		double res = 0;
		for (int i = 0; i < rr.length; i++) {
			res += rr[i].area();
		}
		for (int i = 0; i < cc.length; i++) {
			res += cc[i].area();
		}
		return res;
	}
	
	public static void main(String[] args) {
		Rectangulo[] rectangulos = new Rectangulo[5];
		rectangulos[0] = new Rectangulo(1, 2, 3, 4);
		rectangulos[1] = new Rectangulo(5, 6, 7, 8);
		rectangulos[2] = new Rectangulo(12, 11, 10, 9);
		rectangulos[3] = new Rectangulo(13, 24, 32, 41);
		rectangulos[4] = new Rectangulo(-19, 21, 31, 41);
		
		Circulo[] circulos = {
				new Circulo(1, 2, 3),
				new Circulo(4, 5, 6),
				new Circulo(9, 8, 7)
		};
		
		System.out.println(sumaAreas(rectangulos, circulos));
	}
}
