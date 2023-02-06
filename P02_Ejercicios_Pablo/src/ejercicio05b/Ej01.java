package ejercicio05b;

import java.util.Scanner;

//Pedir al usuario su nombre y saludarlo.
public class Ej01 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingresa tu nombre: ");
		String nombre = tec.nextLine();
		
		System.out.println("Hola " + nombre + " encantado de saludarte!!");
	}
}
