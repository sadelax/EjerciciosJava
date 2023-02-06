package ejercicio01;

import util.Util;

//3. Dado el radio de un círculo, calcular su perímetro y su área.

public class Ejercicio03 {
	public static void main(String[] args) {
		double radio, perimetro, area;
		
		Util.mostrar("Círculo");
		radio = Util.leerDouble("Radio");
		
		perimetro = Math.PI * 2 * radio;
		area = Math.PI * Math.pow(radio, 2);
		
		Util.mostrar("Perimetro: " + perimetro);
		Util.mostrar("Area: " + area);
	}
}
