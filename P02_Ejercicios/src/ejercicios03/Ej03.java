package ejercicios03;
import java.util.Scanner;

public class Ej03 {
	public static void main(String[] arg) {
		System.out.println("Adivinar numero aleatorio.");
		
		int rand, num;
		rand = (int)(Math.random()*100+0);
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Inserta numero del 0 al 100: ");
		num = leer.nextInt();
		
		while(num != rand) {
			if(num > rand) {
				System.out.println("El numero a adivinar es menor.");
				System.out.print("Inserta de nuevo: ");
				num = leer.nextInt();				
			} else {
				System.out.println("El numero a adivinar es mayor.");
				System.out.print("Inserta de nuevo: ");
				num = leer.nextInt();				
			}
		}
		if(num == rand)
			System.out.print("Felicidades!!!!!!!! Has acertado.");
	}
}