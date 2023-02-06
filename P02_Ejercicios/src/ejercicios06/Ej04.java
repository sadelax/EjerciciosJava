package ejercicios06;
// Desarrollar un método que reciba un array de enteros y retorne otro
// con el doble de tamaño y con los valores originales almacenados en las posiciones correspondientes.

public class Ej04 {
	public static int[] duplicaArray(int[] enteros) {
		int[] duplicado = new int[enteros.length * 2];
		for(int i = 0; i < enteros.length; i++) {
			duplicado[i] = enteros[i];
		}
		return duplicado;
	}
	
//	public static void main(String[] args) {
//		int[] original = {1,2,3,4,5};
//		Ej03.muestraArrayInts(duplicaArray(original));
//	}
}
