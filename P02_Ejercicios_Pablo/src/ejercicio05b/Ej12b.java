package ejercicio05b;

//Método que sustituya mayúsculas por minúsculas y minúsculas por mayúsculas en 
//  una frase. Utilizar Character.toUpperCase(char c) y Character.toLowerCase(char c).
public class Ej12b {

	public static void main(String[] args) {
		System.out.println(cambia("Hola Que Tal"));
		System.out.println(cambia("Hola$Que/Tal"));
	}
	
	public static boolean esMayuscula(char c) {
		return c >= 65 && c <= 90;
	}
	
	public static boolean esMinuscula(char c) {
		return c >= 97 && c <= 122;
	}
	
	public static char cambia(char c) {
		return esMayuscula(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
	}
	
	public static String cambia(String str) {
		String resu = "";
		for (int i = 0; i < str.length(); i++) {
			resu = resu + cambia(str.charAt(i));
		}
		return resu;
	}
}
