package ejercicio02;

import util.Util;

//8. Escribir un programa que imprima todos los números pares entre dos números 
//   que se le pidan al usuario

public class Ejercicio08 {
	public static void main(String[] arg) {
		int desde, hasta;
		Util.mostrar("Números pares en un rango");
		desde = Util.leerInt("desde");
		hasta = Util.leerInt("hasta");
		
		if (desde % 2 != 0) desde++;
		
		for (int i = desde; i <= hasta; i+=2) {
			Util.mostrarSinSalto(i + ", ");
		}
	}
}
