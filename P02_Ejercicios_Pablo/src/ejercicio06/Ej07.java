package ejercicio06;

import util.Util;

//Similar al anterior pero que intercale los elementos. 
//  Ej: recibe [1, 2, 3, 4, 5] y [6, 7]; retorna [1, 6, 2, 7, 3, 4, 5].
public class Ej07 {
	

	public static int[] intercala(int[] v1, int[] v2) {
		int[] mayor, menor;
		if (v1.length > v2.length) {
			mayor = v1;
			menor = v2;
		} else {
			mayor = v2;
			menor = v1;
		}
		int[] resu = new int[mayor.length + menor.length];
		for (int i = 0; i < menor.length; i++) {
			resu[2 * i] = v1[i];
			resu[2 * i + 1] = v2[i];
		}
		
		for (int i = menor.length; i < mayor.length; i++) {
			resu[i + menor.length] = mayor[i];
		}
		return resu;
	}
	

	public static void main(String[] args) {
		int[] n1 = {1,2,3,4};
		int[] n2 = {7,8};
		
		Util.mostrarVector(n1);
		Util.mostrarVector(n2);
		
		Util.mostrarVector(intercala(n1, n2));
		Util.mostrarVector(intercala(n2, n1));
	}
}













