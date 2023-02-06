package ejercicio05;

import util.Util;

//Desarrolle un método que reciba una cadena con una expresión de una operación 
//  simple (+, -, *, /) con dos operandos y retorne el resultado como double

public class Ejercicio07a {
	public static void main(String[] args) {
//		System.out.println("15 * 3 = " + calcula("15 * 3"));
//		System.out.println("15.5 / 3 = " + calcula("15.5 / 3"));
//		System.out.println("15.5 + 3.759 = " + calcula("15.5 + 3.759"));
//		System.out.println("12 - 8.65 = " + calcula("12 - 8.65"));
		String operacion = Util.leerString("Ingrese expresion", Util.VENTANA);
		Util.mostrar(calcula(operacion), "Calculadora", Util.VENTANA);
	}
	
	public static double calcula(String operacion) {
		operacion = operacion.replaceAll(" ", "");
		double resu = 0;
		char operador = ' ';
		int pos = 0;
		
		int suma = operacion.indexOf("+"); 
		int resta = operacion.indexOf("-"); 
		int prod = operacion.indexOf("*"); 
		int div = operacion.indexOf("/"); 
		
		if(suma != -1) {
			operador = '+';
			pos = suma;
		}
		if(resta != -1) {
			operador = '-';
			pos = resta;
		}
		if(prod != -1) {
			operador = '*';
			pos = prod;
		}
		if(div != -1) {
			operador = '/';
			pos = div;
		}
		double num1 = Double.parseDouble(operacion.substring(0, pos));
		double num2 = Double.parseDouble(operacion.substring(pos+1));
		
		switch(operador) {
		case '+':
			resu = num1 + num2;
			break;
		case '-':
			resu = num1 - num2;
			break;
		case '*':
			resu = num1 * num2;
			break;
		case '/':
			resu = num2 != 0 ? num1/num2 : 0;
		}
		return resu;
	}
}
