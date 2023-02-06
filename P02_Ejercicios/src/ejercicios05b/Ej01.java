package ejercicios05b;
import java.util.Scanner;
// Pedir al usuario su nombre y saludarlo.

public class Ej01 {
	public static void main(String[] arg) {
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Escribe tu nombre: ");
		String cadena = leer.next();
		System.out.println("Hola " + cadena);
	}
}
