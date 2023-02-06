package ejercicios06;
// Desarrollar un método que reciba un array de doubles y lo ordene de menor
// a mayor sin utilizar ninguna funcionalidad no vista en clase. 
// (Ver previamente métodos de ordenación)

public class Ej09 {
	public static void ordenar(double[] nums) {
		double mayor;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] > nums[j + 1]) {
					mayor = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = mayor;
				}
			}
		}
	}
//	public static void main(String[] args) {
//		double[] nums1 = {3,2,2,1,2.9,5,4};
//		ordenar(nums1);
//		Ej01.muestraArrayDoubles(nums1);
//	}
}
