package ejercicio06;

import util.Util;

//Desarrollar un método que reciba un array de doubles y, en el mismo array, 
//  intercambie los elementos en espejo, es decir, el primero por el último, 
//  el segundo por el penúltimo y así sucesivamente.
public class Ej08 {

	public static void invierte(double[] v) {
		double aux;
		for (int i = 0; i < v.length / 2; i++) {
			aux = v[i];
			v[i] = v[v.length - 1 - i];
			v[v.length - 1 - i] = aux;
		}
	}
	
	public static void main(String[] args) {
		double[] n1 = {1,2,3,4};
		double[] n2 = {7,8,9};
		
		Util.mostrarVector(n1);
		Util.mostrarVector(n2);
		
		invierte(n1);
		invierte(n2);
		Util.mostrarVector(n1);
		Util.mostrarVector(n2);
	}
}













