package ejercicio01;

import util.Util;

//7. Dados dos números, indicar el mayor y el menor valor de los dos.

public class Ejercicio07 {
	public static void main(String[] args) {
		double num1, num2, mayor, menor;
		
		Util.mostrar("Mayor de Dos");
		num1= Util.leerDouble("numero 1");
		num2 = Util.leerDouble("numero 2");
		
		if (num1 > num2) {
			mayor = num1;
			menor = num2;
		} else {
			mayor = num2;
			menor = num1;
		}
		
		Util.mostrar("El mayor es " + mayor);
		Util.mostrar("El menor es " + menor);
	}
}
