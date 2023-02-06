package ejercicio01;

import util.Util;

//6. Dados dos números reales, calcular su suma, diferencia, producto y división.

public class Ejercicio06 {
	public static void main(String[] args) {
		double num1, num2, suma, dif, prod, div;
		
		Util.mostrar("Calculos");
		num1= Util.leerDouble("numero 1");
		num2 = Util.leerDouble("numero 2");
		
		suma = num1 + num2;
		dif = num1 - num2;
		prod = num1 * num2;
		
		Util.mostrar(num1 + " + " + num2 + " = " + suma);
		Util.mostrar(num1 + " - " + num2 + " = " + dif);
		Util.mostrar(num1 + " * " + num2 + " = " + prod);
		
		if (num2 != 0) {
			div = num1 / num2;
			Util.mostrar(num1 + " / " + num2 + " = " + div);
		}
	}
}
