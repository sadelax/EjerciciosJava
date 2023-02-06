package ejercicios02;
import java.util.Scanner;

public class Ej12 {
	public static void main(String[] arg) {
		System.out.println("Numeros triangulares con indice.");
		
		int ind, num = 0, cont = 0;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero: ");
		ind = leer.nextInt();
		
		while(cont < ind) {
			cont++;
			num += cont;
		}
		System.out.print(ind + " - " + num);		
	}
}
