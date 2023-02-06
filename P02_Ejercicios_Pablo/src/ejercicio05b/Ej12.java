package ejercicio05b;

//Método que sustituya mayúsculas por minúsculas y minúsculas por mayúsculas en 
//  una frase. Utilizar Character.toUpperCase(char c) y Character.toLowerCase(char c).
public class Ej12 {

	public static void main(String[] args) {
		System.out.println(cambia("Hola Que Tal"));
	}
	
	public static String cambia(String str) {
		String resu = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i); 
			if (c >= 65 && c <= 90) 
				c = Character.toLowerCase(c);
			else
				c = Character.toUpperCase(c);
			resu = resu + c;
		}
		return resu;
	}
}
