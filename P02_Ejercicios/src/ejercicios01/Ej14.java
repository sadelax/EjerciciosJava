package ejercicios01;
import java.util.Scanner;

public class Ej14 {
	public static void main(String[] arg) {
		System.out.println("Calculadora de años bisiestos.");

		int year;

		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);

		System.out.print("Introduce un año: ");
		year = leer.nextInt();

		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			System.out.print(year + " es efectivamente bisiesto.");
		else
			System.out.print(year + " no es bisiesto.");
	}
}
