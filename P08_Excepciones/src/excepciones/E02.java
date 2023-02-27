package excepciones;

import java.util.Scanner;

public class E02 {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner tec = new Scanner(System.in);
		int num = 0;
		System.out.print("Ingrese valor entero: ");
		
		boolean incorrecto;
		
		do {
			incorrecto = false;
			try {
				num = Integer.parseInt(tec.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("!! escribe un numero entero !!");
				System.out.print("Ingrese valor entero: ");
				incorrecto = true;
			}
			
		} while(incorrecto);
		
		System.out.println(num);
	}
}
