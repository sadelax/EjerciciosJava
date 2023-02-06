package ejercicio06;

import util.Util;

//Desarrollar un método que reciba dos arrays de enteros y retorne un tercero con 
//  todos los elementos del primero y luego los del segundo. 
//  Ej: recibe [1, 2, 3] y [4, 5]; retorna [1,2,3,4,5].

public class Ej06 {
	
	public static int[] agrega(int[] v1, int[] v2) {
		int[] resu = new int[v1.length + v2.length];
		for (int i = 0; i < v1.length; i++) {
			resu[i] = v1[i];
		}
		for (int i = 0; i < v2.length; i++) {
			resu[i + v1.length] = v2[i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
		int[] n1 = {1,2,3,4};
		int[] n2 = {7,8};
		
		Util.mostrarVector(n1);
		Util.mostrarVector(n2);
		
		Util.mostrarVector(agrega(n1, n2));
		Util.mostrarVector(agrega(n2, n1));
	}
}













