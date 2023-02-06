package ejercicios05;
// Haga otra versión del método, pero que reciba una cadena, un carácter y
// la cantidad de dígitos entre las que se debe insertar el carácter.

public class Ej05a {
	public static void main(String[] arg) {
		System.out.println(cadaNDigitos("hola jajaa", '.', 2));
	}
	
	public static String cadaNDigitos(String cadena, char c, int n) {
		String insert = "";
		for(int i = 0, j = n; i <= cadena.length() - 1; i++) {			
			if (i == j) {
				insert += c;
				j += n;
			}
			insert += cadena.charAt(i);
		}
		return insert;
	}
}
