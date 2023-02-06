package ejercicios02;
import java.util.Scanner;

public class Ej15 {
	public static void main(String[] arg) {
		System.out.println("Divisores de un numero.");
		
		int num;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero entero mayor que cero: ");
		num = leer.nextInt();
		
		for(int i = 1; i <= num; i++) {
			if (num % i == 0) System.out.print(i + " ");
		}	
	}
}
