package ejercicios05b;
// Elabora un método que escriba todos los caracteres de una cadena cada uno en una línea.
public class Ej06 {
	public static String caracter(String cadena) {
		String caracter = "";
		for(int i = 0; i < cadena.length(); i++) {
			caracter += cadena.charAt(i) + "\n";
		}
		return caracter;
	}
	
	public static void main(String[] args) {
		System.out.println(caracter("hola"));
		System.out.println(caracter(" hola  "));
	}
}
