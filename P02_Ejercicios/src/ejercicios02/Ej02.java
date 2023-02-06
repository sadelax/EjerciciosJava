package ejercicios02;
import java.util.Scanner;

public class Ej02 {
	public static void main(String[] arg) {
		System.out.println("Imprimir la suma de n numeros naturales.");
		
		int n, num = 0, acum = 0;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe la cantidad de numeros a sumar: ");
		n = leer.nextInt();
		
		while(num < n) {
			System.out.print(num + " + ");
			num++;
			acum += num;
		}
		System.out.print(num + " es " + acum);
	}
}
