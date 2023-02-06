package ejercicio02;

import util.Util;

public class Ejercicio02C {
	public static void main(String[] arg) {
		int acum = 0, cant;
		cant = Util.leerInt("Cantidad de valores aprocesar");

		for(int i = 1; i <= cant; i++) {
			acum += i;
		}
		
		Util.mostrar("La suma de los primeros " + cant + " naturales es " + acum);
	}
}
