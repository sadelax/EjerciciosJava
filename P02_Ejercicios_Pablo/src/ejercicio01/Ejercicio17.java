package ejercicio01;

import util.Util;

//Hacer otro programa que ingresando los mismos datos que el anterior y calcule 
//  el Capital final si no se hace ningún reintegro y la capitalización 
// de los intereses es anual.
//   𝐶𝑓=𝐶𝑖(1+𝑟𝑛)^𝑛𝑡
//   Cf: Capital Final    Ci: Capital Inicial     r: tasa de interés
//   n: cantidad de capitalizaciones anuales      t: tiempo (cantidad de años)

public class Ejercicio17 {
	public static void main(String[] args) {
		double cI, cF, r;
		int n, t;
		
		Util.mostrar("Interés Compuesto");
		cI = Util.leerDouble("Capital a Invertir");
		r = Util.leerDouble("Tasa (valor entre 0 y 1)");
		t = Util.leerInt("Cantidad de años");
		n = Util.leerInt("Cantidad de capitalizaciones anuales");
		
		cF = cI * Math.pow(1+r*n, n*t);
		
		Util.mostrar("Total a obtener: " + String.format("%.2f", cF));
	}
}
