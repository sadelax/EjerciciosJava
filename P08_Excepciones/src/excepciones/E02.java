package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E02 {
	
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		int num = 0;
		System.out.println("Ingrese valor entero: ");
		
		boolean incorrecto;
		
		do {
			incorrecto = false;
			try {
				num = Integer.parseInt(tec.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("escribe un numero por favor");
				incorrecto = true;
			}
			
		} while(incorrecto);
		
		System.out.println(num);
	}
}
