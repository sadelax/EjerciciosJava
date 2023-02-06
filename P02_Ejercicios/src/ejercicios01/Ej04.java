package ejercicios01;
import java.util.Scanner;

public class Ej04 {
	public static void main(String[] arg) {
		System.out.println("Calcular área de un triángulo.");
		
		double base, altura, area;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Dame la base: ");
		base = leer.nextDouble();
		System.out.print("Dame la altura: ");
		altura = leer.nextDouble();
		
		if(base > 0 && altura > 0) {
			area = base * altura / 2;
			System.out.print("El área es " + area);
		} else {
			System.out.print("Por favor, solo entradas positivas gracias.");
		}
	}
}
