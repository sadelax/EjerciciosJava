package ejercicios05b;
// Método que reciba una cadena u un carácter y la retorne pero sólo hasta la primera aparición del carácter dado
// (sin incluirlo). No se puede utilizar indexOf.
public class Ej10 {
	public static void main(String[] args) {
		System.out.println(recortada("hay macarrones en la nevera", 'u'));	// nada
		System.out.println(recortada("quieres algo del max donal", 'x'));	// quieres algo del ma
	}
	public static String recortada(String cadena, char c) {
		cadena = cadena.replaceAll(" +", " ");
		String nuevo = "";
		int i = 0;
		while(i < cadena.length() && cadena.charAt(i) != c) {
			if (i != cadena.length() - 1)
				nuevo += cadena.charAt(i);
			else
				nuevo = "";
			i++;
		}
		return nuevo;
	}
}
