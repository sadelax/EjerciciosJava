package ejercicio03;

import util.Util;

// 2. Se solicitará al usuario que ingrese números reales para procesar. Luego de ingresar cada número,
//   se le preguntará si quiere ingresar más o no, leyendo el carácter ‘s’ o ‘n’.
//   Cuando indique que no ingresa más números, Mostrar la cantidad de valores ingresados, 
//   el primer valor, el último, el mayor y el menor.

public class Ejercicio02 {
	public static void main(String[] arg) {
		Util.mostrar("Carga de valores");
		double num, menor = 0, mayor = 0, primero=0;
		char resp;
		boolean esPrimero = true;

		do {
			num = Util.leerDouble("Ingrese valor real");
			if (esPrimero) {
				primero = mayor = menor = num;
				esPrimero = false;
			}

			if (num > mayor)
				mayor = num;
			else if (num < menor)
				menor = num;

			resp = Util.leerChar("Otro numero? (s/n)");
		} while (resp == 's');

		Util.mostrar("Primer valor ingresado " + primero);
		Util.mostrar("Ultimo valor ingresado " + num);
		Util.mostrar("La nota mayor es " + mayor);
		Util.mostrar("La nota menor es " + menor);
	}
}
