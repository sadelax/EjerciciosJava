package ejercicios05;
// Desarrollar un método que reciba una cadena e inserte un carácter cada 3 caracteres.
// Por ejemplo: “1921680012” y ‘.’, debe retornar “192.168.001.2”
public class Ej05 {
	public static void main(String[] arg) {
		System.out.println(cadaTres("1921680012"));
	}
	
	public static String cadaTres(String original) {
		String insert = "";
		for(int i = 0, j = 3; i < original.length(); i++) {
			if(i == j) {
				insert += '.';
				j+=3;
			}
			insert += original.charAt(i);
		}
		return insert;
	}
}
