package ejercicio05b;

//Pedir al usuario una cadena y decir si empieza por el carácter ‘H’.
//Como el anterior, pero sin importar si es mayúscula o minúscula.
public class Ej04 {
	
	public static void main(String[] args) {
		System.out.println(esH(""));
		System.out.println(esH("Adios"));
		System.out.println(esH("Hola"));
		System.out.println(esH("hola"));
	}
	
	public static boolean esH(String str) {
		return str.length() != 0 && Character.toLowerCase(str.charAt(0)) == 'h';
	}
}
