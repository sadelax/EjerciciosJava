package ejercicios06;
// Desarrollar un método q reciba un array de enteros y retorne otro con los elementos
// ordenados exactamente al revés q el original

public class Ej03 {
	
	public static void muestraArrayInts(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public static int[] alReves(int[] enteros) {
		int[] reves = new int[enteros.length];
		for(int i = enteros.length - 1, j = 0; i >= 0; i--, j++) {
			reves[i] = enteros[j];
		}
		return reves;
	}
	
//	public static void main(String[] args) {
//		int[] original = {1,2,3,4,5};
//		muestraArrayInts(alReves(original));
//	}
}
