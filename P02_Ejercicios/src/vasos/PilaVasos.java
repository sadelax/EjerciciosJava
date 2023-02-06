package vasos;
import java.util.Scanner;

public class PilaVasos {
	public static void main(String[] arg) {
		System.out.println("Algoritmo de ordenacion de vasos.");
		
		int cant, x = 1, y = 1;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Cantidad de vasos: ");
		cant = leer.nextInt();
		for (int i = 1; i <= cant; i++) {
			x = i;
			y = i;
			for (int j = i; j <= cant; j++) {
				System.out.println(x + " " + y);
				y = y + 2;
			}
			System.out.println("...");
		}
	}
}
