package ejercicios06;
// Desarrollar un método que reciba dos arrays de enteros y
// retorne un tercero con todos los elementos del primero y luego los del segundo.
// Ej: recibe [1, 2, 3] y [4, 5]; retorna [1,2,3,4,5].

public class Ej06 {
	public static int[] concat(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length + nums2.length];
		for(int i = 0, j = 0; i < res.length; i++) {
			if(i < nums1.length) {
				res[i] = nums1[i];
			} else {
				res[i] = nums2[j];
				j++;
			}
		}
		return res;
	}
	
//	public static void main(String[] args) {
//		int[] nums1 = {1, 2, 3};
//		int[] nums2 = {4, 5};
//		Ej03.muestraArrayInts(concat(nums1, nums2));
//	}
}
