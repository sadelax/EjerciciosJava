package ejercicios06;
// desarrollar un metodo q reciba un array de enteros y retorne otro con los valores
// originales elevados al cuadrado

public class Ej02 {
	public static double[] elevadosAlCuadrado(int[] enteros) {
		double[] elevados = new double[enteros.length];
		for(int i = 0; i < enteros.length; i++) {
			elevados[i] = Math.pow(enteros[i], 2);
		}
		return elevados;
	}
	
//	public static void main(String[] args) {
//		int[] enteros = {1,2,3,4};
//		Ej01.muestraArray(elevadosAlCuadrado(enteros));
//	}
}
