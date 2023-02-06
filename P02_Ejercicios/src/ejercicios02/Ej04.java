package ejercicios02;
import java.util.Scanner;

public class Ej04 {
	public static void main(String[] arg) {
		System.out.println("Mayor y menor de n numeros.");
		
		int n, cont = 1;
		double num, mayor, menor;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Ingresa la cantidad de numeros: ");
		n = leer.nextInt();		
		System.out.print("Ingresa un numero: ");
		num = leer.nextDouble();
		mayor = menor = num;
		
		while(cont < n) {
			System.out.print("Ingresa un numero: ");
			num = leer.nextDouble();
			if(num > mayor)
				mayor = num;
			else if(num < menor)
				menor = num;
			cont++;
		}
		System.out.print("El menor es " + menor + ", y el mayor es " + mayor);		
	}
}
