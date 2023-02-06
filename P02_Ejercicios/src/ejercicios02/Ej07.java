package ejercicios02;
import java.util.Scanner;

public class Ej07 {
	public static void main(String[] arg) {
		System.out.println("Factorial de un numero.");
		
		int num, res = 1, fact;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);

		System.out.print("Ingresa un numero: ");
		num = leer.nextInt();
		fact = num;
		
		while(num > 1) {
			res *= num;
			num--;
		}
		if(num < 0)
			System.out.print("Por favor introduce solo numeros positivos.");
		else
			System.out.print("El factorial de " + fact + " es " + res);
	}
}
