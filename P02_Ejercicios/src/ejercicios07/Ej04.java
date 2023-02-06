package ejercicios07;
// Desarrollar un método que reciba un array de dos dimensiones de double y retorne la suma de cada columna.
public class Ej04 {
	public static double[] sumaCol(double[][] vec) {
		double res[] = new double[vec[0].length];
		for (int i = 0; i < vec[0].length; i++) {
			for (int j = 0; j < vec.length; j++) {
				res[i] += vec[j][i];
			}
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
//		
//		ejercicios06.Ej01.muestraArrayDoubles(sumaCol(vecs));
//		System.out.println();
//		ejercicios06.Ej01.muestraArrayDoubles(sumaCol(vecs1));
//		System.out.println();
//		ejercicios06.Ej01.muestraArrayDoubles(sumaCol(vecs2));
//		System.out.println();
//		ejercicios06.Ej01.muestraArrayDoubles(sumaCol(vecs3));
//	}

}
