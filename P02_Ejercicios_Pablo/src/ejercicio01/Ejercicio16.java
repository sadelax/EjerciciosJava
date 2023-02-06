package ejercicio01;

import util.Util;

//Escribir un programa que le pregunte al usuario una cantidad de euros
//  a invertir o capital inicial (Ci), una tasa de interés anual (R)
//  y un número de años (T) y muestre como resultado el monto final 
//  a obtener. 
//  Como se irán retirando los intereses generados por año, 
//  se debe calcular con la fórmula de interés simple. 𝐼=𝐶∗𝑅∗𝑇

public class Ejercicio16 {
	public static void main(String[] args) {
		double capitalIni, r, capitalFinal;
		int t;
		
		Util.mostrar("Interés Simple");
		capitalIni = Util.leerDouble("Capital a Invertir");
		r = Util.leerDouble("Tasa (valor entre 0 y 1)");
		t = Util.leerInt("Cantidad de años");
		
		capitalFinal = capitalIni + capitalIni * r * t;
		
		Util.mostrar("Total a obtener: " + capitalFinal);
	}
}
