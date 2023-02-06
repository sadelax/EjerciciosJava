package ejercicio06;

import util.Util;

//Desarrollar un método que reciba un array de enteros y retorne otro con el doble 
//  de tamaño y con los valores originales almacenados en las posiciones 
//  correspondientes
public class Ej04 {

	public static int[] redim(int[] nums) {
		int[] resu = new int[nums.length * 2];
		for (int i = 0; i < nums.length; i++) {
			resu[i] = nums[i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
		int[] n = {1,2,3,4};
		Util.mostrarVector(n);
		
		n = redim(n);
		Util.mostrarVector(n);
		
	}
}













