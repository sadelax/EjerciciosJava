package ejercicio05b;

import java.util.regex.Pattern;

//Método que reciba una cadena y retorne el número de vocales que contiene.
public class Ej08 {
	
	public static void main(String[] args) {
		System.out.println(cuentaVocales("Hola"));
		System.out.println(cuentaVocales("murcielago"));
		System.out.println(cuentaVocales2("Hola"));
		System.out.println(cuentaVocales2("murcielago"));
	}

	public static int cuentaVocales(String str) {
		str = str.toLowerCase();
		int cont = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				cont++;
		}
		return cont;
	}
	
	public static int cuentaVocales2(String str) {
		str = str.toLowerCase();
		int cont = 0;
		for (int i = 0; i < str.length(); i++) {
			if ("aeiou".contains(""+str.charAt(i)))
				cont++;
		}
		return cont;
	}
}
