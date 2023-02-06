package ejercicios02;
import java.util.Scanner;

public class Ej14 {
	public static void main(String[] arg) {
		System.out.println("Cuenta atras.");
		
		int num;

		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero entero positivo: ");
		
		num = leer.nextInt();
		
		for (int i = num; i >= 0; i--) {
			if (i != 0) System.out.print(num + ",");
			else System.out.print(num);
			num--;
		}
	}
}
