package ejercicios07;
// Desarrollar un método que reciba un array de dos dimensiones de double y retorne la suma de cada fila.
public class Ej05 {
	public static double[] sumaFil(double[][] vec) {
		double res[] = new double[vec.length];
		for (int i = 0; i < vec.length; i++) {
			for (int j = 0; j < vec[i].length; j++) {
				res[i] += vec[i][j];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		double[][] vecs = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				};
		double[][] vecs1 = {
				{1,2,3},
				{4,5,6},
		};
		double[][] vecs2 = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{9,9,9},
		};
		double[][] vecs3 = {
				{1,2},
				{3,4},
				{5,6},
		};
		
		Ej01.matrix(vecs);
		ejercicios06.Ej01.muestraArrayDoubles(sumaFil(vecs));
		System.out.println();
		System.out.println("-----------------------");
		System.out.println();
		Ej01.matrix(vecs1);
		ejercicios06.Ej01.muestraArrayDoubles(sumaFil(vecs1));
		System.out.println();
		System.out.println("-----------------------");
		System.out.println();
		Ej01.matrix(vecs2);
		ejercicios06.Ej01.muestraArrayDoubles(sumaFil(vecs2));
		System.out.println();
		System.out.println();
		System.out.println("-----------------------");
		System.out.println();
		System.out.println();
		Ej01.matrix(vecs3);
		ejercicios06.Ej01.muestraArrayDoubles(sumaFil(vecs3));
	}
}
