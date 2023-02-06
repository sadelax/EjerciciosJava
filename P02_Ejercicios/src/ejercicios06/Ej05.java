package ejercicios06;
// Desarrollar un método que reciba, dos arrays de doubles del mismo tamaño 
// y retorne un nuevo array con la suma de los elementos que están en la misma posición.

public class Ej05 {
	public static double[] sumaArrays(double[] nums1, double[] nums2) {
		double[] res = new double[nums1.length];
		for(int i = 0; i < nums1.length; i++) {
			res[i] = nums1[i] + nums2[i];
		}
		return res;
	}
	
//	public static void main(String[] args) {
//		double[] nums1 = {1,1,1,1,1};
//		double[] nums2 = {1,1,1,1,1};
//		
//		Ej01.muestraArrayDoubles(sumaArrays(nums1, nums2));
//	}
}
