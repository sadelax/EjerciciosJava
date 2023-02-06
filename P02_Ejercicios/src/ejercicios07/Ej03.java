package ejercicios07;
// Desarrollar un método que reciba un array de dos dimensiones de double (matriz matemática) 
// y calcule la Traza. La traza es la sumatoria de los elementos de la diagonal principal de una matriz cuadrada. 
// Nosotros la calcularemos para cualquier matriz, no sólo cuadradas.
public class Ej03 {
	public static double traza(double[][] vec) {
		double res = 0;
		for(int i = 0; i < vec.length; i++) {
			if(i < vec[i].length)
				res += vec[i][i];
		}
		return res;
	}
	
//	public static void main(String[] args) {
//		double[][] vecs = {
//				{1,2,3},
//				{4,5,6},
//				{7,8,9},
//				};
//		double[][] vecs1 = {
//				{1,2,3},
//				{4,5,6},
//		};
//		double[][] vecs2 = {
//				{1,2,3},
//				{4,5,6},
//				{7,8,9},
//				{9,9,9},
//		};
//		double[][] vecs3 = {
//				{1,2},
//				{3,4},
//				{5,6},
//		};
//		System.out.println(traza(vecs));
//		System.out.println(traza(vecs1));
//		System.out.println(traza(vecs2));
//		System.out.println(traza(vecs3));
//	}
}
