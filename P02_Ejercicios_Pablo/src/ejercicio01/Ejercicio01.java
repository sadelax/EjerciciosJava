package ejercicio01;

import util.Util;

//1. Dado un número cualquier por teclado, mostrar su valor absoluto.

public class Ejercicio01 {
	public static void main(String[] arg) {
		double num, vAbs;
		
		num = Util.leerDouble("Ingrese valor numerico");
		vAbs = num;
		
		if(num < 0) {
			vAbs = num * -1;
		}
		Util.mostrar("|" + num + "| = " + vAbs);
	}
}
