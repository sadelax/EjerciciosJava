package ejercicio05b;

//Pedir al usuario una frase y un carácter, y decir en qué posiciones está ese 
//  carácter, o indicar que no está si procede. No se puede usar indexOf o similar.
public class Ej07a {
	
	public static void main(String[] args) {
		System.out.println(indexOf("Hola que tal", 'q'));
		System.out.println(indexOf("Hola que tal", 'x'));
	}
	
	public static int indexOf(String str, char c) {
		int pos = -1;
		int i = 0;
		while (i < str.length() && pos == -1) {
			if (str.charAt(i) == c) pos = i;
			i++;
		}
		return pos;
	}
}
