package ejercicios01;
import java.util.Scanner;

public class Ej09 {
	public static void main(String[] arg) {
		System.out.println("Conversor F a C");
		
		double fahr, cel;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Temperatura en Fahrenheit: ");
		fahr = leer.nextDouble();
		
		cel = (fahr - 32) * 5 / 9;
		
		System.out.print(fahr + " grados Fahrenheit son " + cel + " grados Celsius.");		
	}
}
