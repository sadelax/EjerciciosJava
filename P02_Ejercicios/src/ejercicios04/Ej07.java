package ejercicios04;
import java.util.Scanner;
// 7. Determine si un valor entero ingresado por teclado es un palíndromo (capicúa).
public class Ej07 {
	public static void main(String[] arg) {		
		int num, aux = 0, inv = 0, cpy = 0;
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingresa un valor: ");
		num = leer.nextInt();
		aux = cpy = num;
		while (num > 0) {
			aux = num % 10;
			num /= 10;
			inv = aux + inv * 10;
		}
		System.out.println(inv == cpy ? cpy + " es capicua." : cpy + " no es capicua.");
	}
}
