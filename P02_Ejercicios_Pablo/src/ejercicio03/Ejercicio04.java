package ejercicio03;

import util.Util;

//4. Realizar un programa que adivine el número (entre 0 y 100) que ha pensado el usuario. 
//  En cada paso, el programa propone un número y el usuario debe contestar, introduciendo su 
//  contestación como dato, si ha acertado, o bien si el número que ha propuesto el ordenador 
//  es mayor o es menor que el que tenía pensado. 
//  Por ejemplo, ingresando: 
//    0 –> Acierto 
//    1 –> El valor propuesto es mayor 
//   -1 –> El valor propuesto es Menor

public class Ejercicio04 {
	public static void main(String[] arg) {
		int min = 0;
		int max = 100;
		Util.mostrar("Adivina numero");
		Util.mostrar("Debes pensar un número (Entre " + min + " y " + max + ") y yo te lo adivino");
		int num;
		boolean acierto = false;
		int cont = 0, opcion;
		
		do {
			num = (min + max) / 2;
			cont ++;
			Util.mostrar("Es el número " + num + " ?");
			Util.mostrar("1 - No " + num + " es mayor");
			Util.mostrar("2 - No " + num + " es menor");
			Util.mostrar("0 - He acertado");
			opcion = Util.leerInt(">");
			switch (opcion) {
			case 0:
				acierto = true;
				break;
			case 1:
				max = num - 1;
				break;
			case 2:
				min = num + 1;
			}
		} while (!acierto);
		Util.mostrar("Lo he adivinado en "+ cont + " intentos");
	}
}
