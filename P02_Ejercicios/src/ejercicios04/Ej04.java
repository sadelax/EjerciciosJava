package ejercicios04;
import java.util.Scanner;
// Ingresando un número entero por teclado de 4 cifras, mostrar sus dígitos uno por línea.
public class Ej04 {
	public static void main(String[] arg) {
		int num;
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingresa un numero de 4 cifras: ");
		num = leer.nextInt();
		for(int i = 1; i <= 4; i++) {
			if (i == 1)
				System.out.println(num / 1000 % 10);
			else if (i == 2)
				System.out.println(num / 100 % 10);
			else if (i == 3)
				System.out.println(num / 10 % 10);
			else if (i == 4)
				System.out.println(num % 10);
		}
	}
}
