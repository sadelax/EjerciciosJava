package ejercicios02;
import java.util.Scanner;

public class Ej03 {
	public static void main(String[] arg) {
		System.out.println("Imprimir el mayor de n numeros.");
		
		int n, cont = 1;
		double num, mayor;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Cantidad de numeros a ingresar: ");
		n = leer.nextInt();
		
		if(n > 0) {
			System.out.print("Escribe un numero: ");
			num = leer.nextDouble();
			mayor = num;
			while(cont < n) {
				System.out.print("Escribe un numero: ");
				num = leer.nextDouble();
				if(num > mayor)
					mayor = num;
				cont++;
			}
			System.out.print("El mayor de los numeros ingresados es " + mayor);
		}
	}
}
