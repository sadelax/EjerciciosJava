package ejercicios05;
// Desarrollar un método que reciba una cadena y un carácter 
// e inserte el carácter entre cada letra de la cadena. 
// Ej: “separar” y ’-’ debería retornar “s-e-p-a-r-a-r”
public class Ej04 {
	public static void main(String[] arg) {
		System.out.println(separar("separar", '-'));
	}
	public static String separar(String original, char c) {
		String separado = "" + original.charAt(0);
		for(int i = 1; i < original.length(); i++) {
			separado += "" + c + original.charAt(i);		
		}
		return separado;
	}
}
