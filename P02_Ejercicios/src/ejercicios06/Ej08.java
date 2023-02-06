package ejercicios06;
// Desarrollar un método que reciba un array de doubles y, en el mismo array, 
// intercambie los elementos en espejo, es decir, el primero por el último, 
//  segundo por el penúltimo y así sucesivamente.

public class Ej08 {
	public static void espejo(double[] nums) {
		double aux;
		for(int i = 0; i < nums.length / 2; i++) {
			aux = nums[i];
			nums[i] = nums[nums.length - i - 1];
			nums[nums.length - i - 1] = aux;
		}
 	}
//	public static void main(String[] args) {
//		double[] nums = { 1,2,3,4,5};
//		System.out.println("original: ");
//		Ej01.muestraArrayDoubles(nums);
//		espejo(nums);
//		System.out.println("");
//		System.out.println("espejo: ");
//		Ej01.muestraArrayDoubles(nums);
//	}
}
