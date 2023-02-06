package ejercicio05b;

//Programa que diga si una cadena dada por el usuario está o no vacía.
public class Ej02 {
	
	public static void main(String[] args) {
		System.out.println(esVacia(""));
		System.out.println(esVacia(" "));
		System.out.println(esVacia("Hola"));
	}
	
	public static boolean esVacia(String str) {
		return str.length() == 0;
	}
}
