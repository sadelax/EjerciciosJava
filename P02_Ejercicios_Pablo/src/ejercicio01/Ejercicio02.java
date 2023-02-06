package ejercicio01;

import util.Util;

//2. Dados los lados de un rectángulo, calcular su perímetro y su área.

public class Ejercicio02 {
	public static void main(String[] args) {
		double lado1, lado2, perimetro, area;
		
		Util.mostrar("Rectangulo");
		lado1 = Util.leerDouble("Lado 1");
		lado2 = Util.leerDouble("Lado 2");
		
		perimetro = lado1 * 2 + lado2 * 2;
		area = lado1 * lado2;
		
		Util.mostrar("Perimetro: " + perimetro);
		Util.mostrar("Area: " + area);
	}
}
