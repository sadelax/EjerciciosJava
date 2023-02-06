package ejercicios02;
import java.util.Scanner;

public class Ej08 {
	public static void main(String[] arg) {
		System.out.println("Imprimir todos los numeros pares entre 2 numeros.");
		
		int pares, min, max;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero: ");
		min = leer.nextInt();
		System.out.print("Escribe otro numero: ");
		max = leer.nextInt();
		
		if(min % 2 != 0)
			pares = min + 1;
		else
			pares = min;
		while(pares < max) {
			System.out.print(pares + " ");
			pares += 2;
		}
	}
}
