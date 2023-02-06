package ejercicio02;

import util.Util;

public class Ejercicio02 {
	public static void main(String[] arg) {
		int cont = 1, acum = 0, cant;
		cant = Util.leerInt("Cantidad de valores a procesar");
		while(cont <= cant) {
			acum = acum + cont;
			cont = cont + 1;
		}
		Util.mostrar("La suma de los primeros " + cant + " naturales es " + acum);
	}
}
