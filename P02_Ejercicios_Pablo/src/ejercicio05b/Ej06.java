package ejercicio05b;

//Elabora un método que escriba todos los caracteres de una cadena cada uno 
//  en una línea
public class Ej06 {

	public static void main(String[] args) {
		divide("Hola");
	}
	
	public static void divide(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}
}
