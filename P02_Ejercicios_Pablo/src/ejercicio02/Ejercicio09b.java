package ejercicio02;

import util.Util;

//Solicitando al usuario la cantidad de números a procesar, emitir el siguiente informe: 
//   Cantidad de nos. Ingresados: xx 
//   Sumatoria: xxx Cantidad de nros positivos o 0: xx 
//   Cantidad de nros negativos: xx 
//   Cantidad de nros pares: xx 
//   Cantidad de nros impares: xx 
//   Mayor valor: xxx – ingresado en el lugar: xx 
//   Menor valor: xxx – ingresado en el lugar: xx Media: xx

public class Ejercicio09b {
	public static void main(String[] arg) {
		int cant, positivos=0, negativos, pares=0, impares, posMayor=1, posMenor=1;
		double num, suma=0, mayor=0, menor=0;
		
		Util.mostrar("Informe");
		cant = Util.leerInt("Cantidad números a procesar");

		num = Util.leerDouble("n");
		mayor = menor = num;
		suma += num;
		if (num >= 0) positivos++;
		if (num % 2 == 0) pares++;
		
		for (int i = 2; i <= cant; i++) {
			num = Util.leerDouble("n");
			suma += num;
			if (num > mayor) {
				mayor = num;
				posMayor = i;
			} else if (num < menor) {
				menor = num;
				posMenor = i;
			}
			if (num >= 0) positivos++;
			if (num % 2 == 0) pares++;
		}
		negativos = cant - positivos;
		impares = cant - pares;
		
		Util.mostrar("Cantidad de nos. Ingresados: " + cant);
		Util.mostrar("Sumatoria: " + suma);
		Util.mostrar("Cantidad de nros positivos o 0: " + positivos);
		Util.mostrar("Cantidad de nros negativos: " + negativos);
		Util.mostrar("Cantidad de nros pares: " + pares);
		Util.mostrar("Cantidad de nros impares: " + impares);
		Util.mostrar("Mayor valor: " + mayor + " – ingresado en el lugar: " + posMayor);
		Util.mostrar("Menor valor: " + menor + " – ingresado en el lugar: " + posMenor);
	}
}
