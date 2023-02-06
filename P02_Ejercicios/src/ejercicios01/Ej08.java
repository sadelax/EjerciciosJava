package ejercicios01;
import java.util.Scanner;

public class Ej08 {
	public static void main(String[] arg) {
		System.out.println("Mayor de 3");
		
		double num1, num2, num3;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero: ");
		num1 = leer.nextDouble();
		System.out.print("Escribe un numero: ");
		num2 = leer.nextDouble();
		System.out.print("Escribe un numero: ");
		num3 = leer.nextDouble();
	
		if(num3 >= num1 && num3 >= num2) {
			System.out.print(num3);
		} else if (num2 >= num3 && num2 >= num1) {
			System.out.print(num2);			
		} else {
			System.out.print(num1);
		}
	}
}