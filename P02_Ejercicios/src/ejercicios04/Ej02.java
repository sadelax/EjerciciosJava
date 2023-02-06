package ejercicios04;
import java.util.Scanner;

public class Ej02 {
	public static void main(String[] arg) {
		System.out.println("Imprime un cuadrado relleno.");
		int lado;
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Ingrese valor: ");
		lado = leer.nextInt();
			
		for(int i = 1; i <= lado; i++) {
			for(int j = 1; j <= lado; j++) {
				System.out.print("*");
			}
			System.out.print("\n");			
		}
	}
}
