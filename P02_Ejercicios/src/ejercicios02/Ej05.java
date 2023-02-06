package ejercicios02;
import java.util.Scanner;

public class Ej05 {
	public static void main(String[] arg) {
		System.out.println("Cantidad de positivos ingresados.");
		
		int n, cont = 0, acum = 0;
		double num;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Ingresa la cantidad de numeros a calcular: ");
		n = leer.nextInt();
		
		while(cont < n) {
			System.out.print("Ingresa un numero: ");
			num = leer.nextDouble();
			if(num > 0)
				acum++;
			cont++;
		}
		System.out.print("De " + n + " numeros que has escrito, " + acum + " son positivos.");		
	}
}
