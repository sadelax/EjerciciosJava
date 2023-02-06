package ejercicios07;
// Desarrollar un método que reciba un array de dos dimensiones de double
// y retorne la suma total de todos los elementos.
public class Ej02 {
	public static double suma(double[][] vec) {
		double res = 0;
		for(int i = 0; i < vec.length; i++) {
			for(int j = 0; j < vec[i].length; j++) {
				res += vec[i][j];
			}
		}
		return res;
	}
	
//	public static void main(String[] args) {
//		double[][] vec = {
//				{1,2,3},
//				{4,5,6}
//				};
//		System.out.println(suma(vec));
//	}
}
