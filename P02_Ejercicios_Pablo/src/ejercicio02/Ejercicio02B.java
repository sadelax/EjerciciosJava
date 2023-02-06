package ejercicio02;

import util.Util;

public class Ejercicio02B {
	public static void main(String[] arg) {
		int cont = 1, acum = 0, cant;
		cant = Util.leerInt("Cantidad de valores aprocesar");
		while(cont <= cant) {
			acum += cont; // acum = acum + cont
			cont++; // cont = cont + 1
		}
		Util.mostrar("La suma de los primeros " + cant + " naturales es " + acum);
	}
}
