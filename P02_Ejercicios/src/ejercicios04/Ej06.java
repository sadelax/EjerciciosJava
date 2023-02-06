package ejercicios04;
import java.util.Scanner;
// Ingresando un valor entero, muestre por pantalla sus dígitos en orden inverso.
public class Ej06 {
	public static void main(String[] arg) {
		int num;
		System.out.print("Ingresa un numeroooo: ");
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		num = leer.nextInt();
		while (num > 0) {
			System.out.println(num % 10);
			num /= 10;
		}
	}
}
