package ejercicios06;
//Similar al anterior pero que intercale los elementos. 
// Ej: recibe [1, 2, 3, 4, 5] y [6, 7]; retorna [1, 6, 2, 7, 3, 4, 5].

public class Ej07 {
	public static int[] intercala(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length + nums2.length];
		for(int i = 0, j = 0; i < res.length; i++) {
			if(i < nums1.length) {
				res[j] = nums1[i];
				j++;
			}
			if(i < nums2.length) {
				res[j] = nums2[i];
				j++;
			}
		}
		
		return res;
	}
	
//	public static void main(String[] args) {
//		int[] nums1 = {1,2,3,4,5};
//		int[] nums2 = {6,7};
//		Ej03.muestraArrayInts(intercala(nums1, nums2));
//	}
}
