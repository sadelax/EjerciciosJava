package ejercicio01;

import util.Util;

//Escribir un programa que dados dos puntos en el plano 𝐴(𝑥1,𝑦1) y 𝐵(𝑥2,𝑦2), 
//  imprima la distancia entre ambos.
//  𝑑(𝐴,𝐵)= √((𝑥2− 𝑥1)^2+(𝑦2− 𝑦1)^2)

public class Ejercicio18 {
	public static void main(String[] args) {
		double x1, y1, x2, y2, d;

		Util.mostrar("Distancia entre dos puntos");
		x1 = Util.leerDouble("Punto A x");
		y1 = Util.leerDouble("Punto A y");
		x2 = Util.leerDouble("Punto B x");
		y2 = Util.leerDouble("Punto B y");
		
		d = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		
		Util.mostrar("A = (" + x1 + ", " + y1 + ")");
		Util.mostrar("B = (" + x2 + ", " + y2 + ")");
		Util.mostrar("d(A,B) = " + d);
	}
}
