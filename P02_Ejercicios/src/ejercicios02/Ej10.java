package ejercicios02;
import java.util.Scanner;

public class Ej10 {
	public static void main(String[] arg) {
		System.out.println("Imprimir la tabla de multiplicar de un numero n.");
		
		int num, cont = 0, res = 0;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero: ");
		num = leer.nextInt();
		
		while(cont <= 9) {
			System.out.println(num + " por " + cont + " = " + res);
			cont++;
			res = num * cont;
		}
		
	}
}
