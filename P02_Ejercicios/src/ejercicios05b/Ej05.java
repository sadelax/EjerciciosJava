package ejercicios05b;
// Método que pida un carácter c y un número n y que devuelva una cadena con c repetido n veces.

public class Ej05 {
	public static String multipleC(char c, int n) {
		String cadena = "";
		for(int i = 0; i < n; i++) {
			cadena += c;
		}
		return cadena;
	}
	
	public static void main(String[] arg) {
		System.out.println(multipleC('x', 5));
		// output: xxxxx
	}
}
