package ejercicios04;
import java.util.Scanner;
// Utilice ciclos for para generar los patrones.
// Todos los asteriscos deberán ser impresos por un solo enunciado print de la forma print(‘*’).
// los dos últimos patrones requieren que cada línea comience con un número correcto de espacios en blanco: print(‘ ’).
public class Ej08 {
	public static void main(String[] arg) {
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese valor: ");				
		int num = leer.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");	
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		for(int i = 1; i <= num; i++) {
			for(int j = i; j <= num; j++) {
				System.out.print("*");				
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				System.out.print(j >= i ? "*" : " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				System.out.print(j <= i ? "*" : " ");					
			}
			System.out.print("\n");
		}
	}
}
