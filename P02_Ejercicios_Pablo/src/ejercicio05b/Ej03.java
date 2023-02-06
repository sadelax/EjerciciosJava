package ejercicio05b;

//Pedir al usuario una cadena y decir si empieza por el carácter ‘H’.
public class Ej03 {
	
	public static void main(String[] args) {
		System.out.println(esH(""));
		System.out.println(esH("Adios"));
		System.out.println(esH("Hola"));
		System.out.println(esH("hola"));
	}
	
	public static boolean esH(String str) {
		return str.length() != 0 && str.charAt(0) == 'H';
	}
}
