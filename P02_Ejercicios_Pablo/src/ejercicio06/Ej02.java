package ejercicio06;

import util.Util;

//Desarrollar un método que reciba un array de enteros y retorne otro con los valores
//  originales elevados al cuadrado

public class Ej02 {

	public static int[] cuadrado(int[] nums) {
		int[] resu = new int[nums.length];
		for (int i = 0; i < resu.length; i++) {
			resu[i] = (int)Math.pow(nums[i], 2);
//			resu[i] = nums[i] * nums[i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
//		int[] n = {1,2,3,4};
//
//		Util.mostrarVector(cuadrado(n));
		
		Util.mostrarVector(cuadrado(new int[] {5,6,7,8}));

	}
}
