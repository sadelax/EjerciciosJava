package ejercicio06;

// Desarrollar un metodo que muestre por pantalla un array de doubles
public class Ej01 {
	
	public static void muestraArray(double[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public static void main(String[] args) {
		double[] n = {1,2,3,4};

		muestraArray(n);
		
		muestraArray(new double[] {5,6,7,8});
		
	}
}
