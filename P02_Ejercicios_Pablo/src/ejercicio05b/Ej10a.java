package ejercicio05b;

//Método que reciba una cadena u un carácter y la retorne pero sólo hasta la primera
//  aparición del carácter dado (sin incluirlo). No se puede utilizar indexOf.
public class Ej10a {
	
	public static void main(String[] args) {
		System.out.println(substringChar("esto es una frase", ' '));
		System.out.println(substringChar("esto es una frase", 'x'));
	}

	public static String substringChar(String str, char c) {
		int i = 0, pos = -1;
		while (i < str.length() && pos == -1) {
			if (str.charAt(i) == c) 
				pos = i;
			i++;
		}
		return pos != -1 ? str.substring(0, pos) : str;
	}
}
