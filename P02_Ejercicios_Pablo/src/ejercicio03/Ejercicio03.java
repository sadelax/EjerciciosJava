package ejercicio03;

import util.Util;

//3. El programa generará un número aleatorio entre 0 y 100 y le pedirá al usuario que lo adivine. 
//    Cuando el usuario ingrese el número para ver si acertó, el programa le indicará 
//    si el número a adivinar es mayor, menor o bien si acertó. Cuando acierte, finaliza.

public class Ejercicio03 {
	public static void main(String[] arg) {
		Util.mostrar("Adivina numero");
		Util.mostrar("Debes adivinar el número secreto (Entre 0 y 100)");
		int num, usuario;
		num = Util.random(0, 100);
		boolean acierto = false;

		do {
			usuario = Util.leerInt("Cual es el número?");
			if (usuario < num) Util.mostrar("Tu número es muy pequeño...");
			if (usuario > num) Util.mostrar("Tu número es muy GRANDE...");
			if (usuario == num) {
				Util.mostrar("Has acertado!!!!");
				acierto = true;
			}
		} while (!acierto);
	}
}
