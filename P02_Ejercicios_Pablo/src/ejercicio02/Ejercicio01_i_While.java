package ejercicio02;

import util.Util;

//Imprimir por pantalla los números 1 hasta un número ingresado por teclado.

public class Ejercicio01_i_While {
	public static void main(String[] arg) {
		int cont = 1, cant;
		cant = Util.leerInt("Hasta que numero necesitas");
		
		while(cont <= cant) {
			Util.mostrarSinSalto(cont + ", ");
			cont = cont + 1;
		}
	}
}
