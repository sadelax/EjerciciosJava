package ejercicios02;
import java.util.Scanner;

public class Ej16 {
	public static void main(String[] arg) {
		System.out.println("Escribir un programa que pida al usuario un número entero positivo mayor que 2 y "
				+ "muestre por pantalla si es un número primo o no.");
		
		int num, divCont = 0;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero mayor que 2: ");
		num = leer.nextInt();
		
		for (int i = 1; i <= num && divCont < 2; i++) {
			if (num % i == 0) divCont++;				
		}
		System.out.print(divCont);

		System.out.print(divCont <= 2 ? "Es primo" : "No es primo");
	}
}
