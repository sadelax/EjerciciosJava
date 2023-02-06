package ejercicio06;

import util.Util;

//Desarrollar un método que reciba un array de enteros y retorne otro con los elementos
//  ordenados exactamente al revés que el original
public class Ej03 {

	public static int[] invierte2(int[] nums) {
		int[] resu = new int[nums.length];
		for (int i = 0, j = resu.length - 1; i < resu.length; i++, j--) {
			resu[i] = nums[j];			
		}
		return resu;
	}
	
	public static int[] invierte(int[] nums) {
		int[] resu = new int[nums.length];
		for (int i = 0; i < resu.length; i++) {
			resu[i] = nums[resu.length - 1 - i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
		int[] n = {1,2,3,4};

		Util.mostrarVector(invierte(n));
		Util.mostrarVector(invierte2(n));
		
		Util.mostrarVector(invierte(new int[] {5,6,7,8}));
		Util.mostrarVector(invierte2(new int[] {5,6,7,8}));
	}
}
