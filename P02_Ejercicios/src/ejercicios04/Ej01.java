package ejercicios04;
import java.util.Scanner;
import util.Util;

public class Ej01 {
	public static void main(String[] arg) {
		System.out.println("Calculadora de 4 operaciones.");
		
		double num1, num2, res = 0;
		String sign;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese valor: ");
		num1 = leer.nextDouble();
		System.out.print("Ingrese valor: ");
		num2 = leer.nextDouble();
		sign = Util.leerString("Ingrese operacion");
		
		switch(sign) {
		case "+":
			res = num1 + num2;
			break;
		case "-":
			res = num1 - num2;
			break;
		case "*":
			res = num1 * num2;
			break;
		case "/":
			res = num1 / num2;
			break;
		}
		System.out.print(num1 + sign + num2 + "=" + res);
	}
}
