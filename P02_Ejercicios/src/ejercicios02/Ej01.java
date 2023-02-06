package ejercicios02;
import java.util.Scanner;

public class Ej01 {
	public static void main(String[] arg) {
		System.out.println("imprimir n numeros.");
		
		int n, num = 0;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);

		System.out.print("Ingresa la cantidad de numeros a imprimir: ");
		n = leer.nextInt();
		
		while(num < n) {
			num += 1;
			System.out.print(num);
		}
	}
}
