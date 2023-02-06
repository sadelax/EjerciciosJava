package ejercicios06;
// Repetir el método, pero para arrays de diferentes tamaños.

public class Ej05a {
	public static double[] sumaDifArrays(double[] nums1, double[] nums2) {
		double[] mayor, menor;
		if(nums1.length > nums2.length) {
			mayor = nums1;
			menor = nums2;
		} else {
			mayor = nums2;
			menor = nums1;
		}
		double[] res = new double[mayor.length];
		for(int i = 0; i < res.length; i++) {
			if(i < menor.length) {
				res[i] = menor[i] + mayor[i];
			} else {
				res[i] += mayor[i];
			}
		}
		return res;
	}
	
//	public static void main(String[] args) {
//		double[] nums1 = {1,1,1,1,1};
//		double[] nums2 = {1,1,1,1,1,1,1,1,1,1};
//		Ej01.muestraArrayDoubles(sumaDifArrays(nums1, nums2));
//	}
}
