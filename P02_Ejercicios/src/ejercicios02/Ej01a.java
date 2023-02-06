package ejercicios02;
import java.util.Scanner;

public class Ej01a {
	public static void main(String[] arg) {
		System.out.println("Imprimir la suma de n numeros.");
		
		int n, cont = 0, num = 0, acum = 0;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);

		System.out.print("Ingresa el numero de numeros a sumar: ");
		n = leer.nextInt();
		
		while(cont < n) {
			cont += 1;
			System.out.print("ingresa un numero: ");
			num = leer.nextInt();
			acum += num;
		}
		System.out.println("La suma total es " + acum);
	}
}
