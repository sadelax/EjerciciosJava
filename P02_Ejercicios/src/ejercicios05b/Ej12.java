package ejercicios05b;
// Método que sustituya mayúsculas por minúsculas y minúsculas por mayúsculas en una frase. 
// Utilizar Character.toUpperCase(char c) y Character.toLowerCase(char c).
public class Ej12 {
	public static void main(String[] args) {
		System.out.println(minusMayus("Hola que pasa"));
	}
	public static String minusMayus(String frase) {
		String nuevo = "";
		for(int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) >= 65 && frase.charAt(i) <= 90) {
				nuevo += Character.toLowerCase(frase.charAt(i));
			} else
				nuevo += Character.toUpperCase(frase.charAt(i));
		}
		return nuevo;
	}
}
