package ejercicios01;
import java.util.Scanner;

public class Ej13 {
	public static void main(String[] arg) {
		System.out.println("Par o impar.");

		int num;

		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);

		System.out.print("Escribe un numero: ");
		num = leer.nextInt();

		if(num % 2 == 0)
			System.out.print(num + " es par.");
		else
			System.out.print(num + " es impar.");
	}
}
