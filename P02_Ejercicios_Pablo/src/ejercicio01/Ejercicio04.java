package ejercicio01;

import util.Util;

//4. Dados la base y altura de un triángulo, calcular su área.

public class Ejercicio04 {
	public static void main(String[] args) {
		double base, altura, area;
		
		Util.mostrar("Triángulo");
		base = Util.leerDouble("Base");
		altura = Util.leerDouble("Altura");
		
		area = base * altura / 2;
		
		Util.mostrar("Area: " + area);
	}
}
