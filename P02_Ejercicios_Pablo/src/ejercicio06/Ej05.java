package ejercicio06;

import util.Util;

//Desarrollar un método que reciba, dos arrays de doubles del mismo tamaño y retorne
//  un nuevo array con la suma de los elementos que están en la misma posición.
//   a. Repetir el método, pero para arrays de diferentes tamaños.
public class Ej05 {
	

	public static double[] sumaIguales(double[] v1, double[] v2) {
		if (v1.length != v2.length) 
			return null;
		
		double[] resu = new double[v1.length];
		for (int i = 0; i < resu.length; i++) {
			resu[i] = v1[i] + v2[i];
		}
		return resu;
	}
	
	public static double[] suma(double[] v1, double[] v2) {
		double[] mayor, menor;
		if (v1.length > v2.length) {
			mayor = v1;
			menor = v2;
		} else {
			mayor = v2;
			menor = v1;
		}
		double[] resu = new double[mayor.length];
		for (int i = 0; i < menor.length; i++)
			resu[i] = mayor[i] + menor[i];
		
		for (int i = menor.length; i < mayor.length; i++) {
			resu[i] = mayor[i];
		}
		return resu;
	}
	
	public static double[] suma2(double[] v1, double[] v2) {
		double[] resu = new double[Math.max(v1.length, v2.length)];
		for (int i = 0; i < resu.length; i++) {
			resu[i] = (i < v1.length ? v1[i] : 0) + (i < v2.length ? v2[i] : 0); 
		}
		return resu;
	}

	public static double[] suma3(double[] v1, double[] v2) {
		double[] mayor, menor;
		if (v1.length > v2.length) {
			mayor = v1;
			menor = v2;
		} else {
			mayor = v2;
			menor = v1;
		}
		double[] resu = mayor.clone();
		for (int i = 0; i < menor.length; i++)
			resu[i] += menor[i];
		
		return resu;
	}

	public static void main(String[] args) {
		double[] n1 = {1,2,3,4};
		double[] n2 = {7,8};
		
		Util.mostrarVector(n1);
		Util.mostrarVector(n2);
		
//		Util.mostrarVector(sumaIguales(n1, n2));
		Util.mostrarVector(suma(n1, n2));
		Util.mostrarVector(suma(n2, n1));
		Util.mostrarVector(suma2(n1, n2));
		Util.mostrarVector(suma2(n2, n1));
		Util.mostrarVector(suma3(n1, n2));
		Util.mostrarVector(suma3(n2, n1));
	}
}













