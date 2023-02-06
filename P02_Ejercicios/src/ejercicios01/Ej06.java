package ejercicios01;
import java.util.Scanner;

public class Ej06 {
	public static void main(String[] arg) {
		System.out.println("Suma, resta, producto y division.");
		
		double num1, num2, sum, dif, prod, div;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Dame un numero: ");
		num1 = leer.nextDouble();
		System.out.print("Dame otro numero: ");
		num2 = leer.nextDouble();
			
		sum = num1 + num2;
		dif = num1 - num2;
		prod = num1 * num2;
			
		System.out.println(num1 + " + " + num2 + " = " + sum);
		System.out.println(num1 + " - " + num2 + " = " + dif);
		System.out.println(num1 + " * " + num2 + " = " + prod);
		
		if (num2 != 0) {
			div = num1 / num2;
			System.out.println(num1 + " / " + num2 + " = " + div);
		} else System.out.println(num1 + " / " + num2 + " = undefined");
	}
}
