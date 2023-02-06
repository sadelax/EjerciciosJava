package ejercicios05;
// Desarrollar un método que reciba una cadena y retorne otra con la original invertida.
public class Ej01 {
	public static void main(String[] arg) {
		System.out.println(invierte("hola"));
	}
	public static String invierte(String original) {
		String inv = "";
		for (int i = original.length() -1; i >= 0; i--)
			inv = inv + original.charAt(i);
		return inv;
	}
}
