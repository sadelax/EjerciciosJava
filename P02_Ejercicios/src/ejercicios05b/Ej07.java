package ejercicios05b;
// Pedir al usuario una frase y un carácter, y decir en qué posiciones está ese carácter, 
// o indicar que no está si procede. No se puede usar indexOf o similar.
public class Ej07 {
	public static void main(String[] arg) {
		System.out.println(posicionDe("aaaavvvvivar", 'g'));
	}
	
	public static int posicionDe(String frase, char c) {
		int pos = -1;
		int i = 0;
		while(i < frase.length() && pos == -1) {
			if (frase.charAt(i) == c)
				pos = i;
			i++;
		}
		return pos;
	}
}
