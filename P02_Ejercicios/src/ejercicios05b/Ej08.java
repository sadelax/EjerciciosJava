package ejercicios05b;
// Método que reciba una cadena y retorne el número de vocales que contiene.
public class Ej08 {
	public static int numeroDeVocales(String cadena) {
		int cont = -1;
		int i = 0;
		while(i < cadena.length() && cont == -1) {
			if(cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i'|| cadena.charAt(i) == 'o' || cadena.charAt(i) == 'u') {
				cont++;
			}
			if(cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E' || cadena.charAt(i) == 'I'|| cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U') {
				cont++;
			}
			i++;
		}
		return cont;
	}
}
