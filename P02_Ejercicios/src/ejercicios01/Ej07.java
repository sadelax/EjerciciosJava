package ejercicios01;
import java.util.Scanner;

public class Ej07 {
	public static void main(String[] arg) {
		System.out.println("Definir el mayor de dos numeros.");
		
		double num1, num2;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero: ");
		num1 = leer.nextInt();
		System.out.print("Escribe otro numero: ");
		num2 = leer.nextInt();
			
		if(num1 > num2)	System.out.print("El mayor es " + num1);
		else System.out.print("El mayor es " + num2);
	}
}
