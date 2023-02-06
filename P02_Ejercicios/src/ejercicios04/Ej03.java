package ejercicios04;
import java.util.Scanner;

public class Ej03 {
	public static void main(String[] arg) {
		System.out.println("Imprime el perimetro de un cuadrado.");
		
		int lado;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese valor: ");
		
		lado = leer.nextInt();
		
		for(int i = 1; i <= lado; i++) {
			for(int j = 1; j <= lado; j++) {
				if (i == 1 || i == lado)
					System.out.print("*");
				else if (j == 1 || j == lado)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
