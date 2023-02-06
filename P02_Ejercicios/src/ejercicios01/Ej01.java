package ejercicios01;
import java.util.Scanner;

public class Ej01 {
	public static void main(String[] arg) {
		System.out.println("Valor absoluto.");
		
		double numero;
		double abs;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Introduce un número: ");
		numero = leer.nextInt();
		
		abs = numero < 0 ? numero * -1 : numero;
			
		System.out.println("El valor absoluto de " + numero + " es " + abs);			
	}
}
