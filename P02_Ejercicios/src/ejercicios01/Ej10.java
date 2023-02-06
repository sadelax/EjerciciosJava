package ejercicios01;
import java.util.Scanner;

public class Ej10 {
	public static void main(String[] arg) {
		System.out.println("Obtener cantidad de segundos.");
		
		int hor, min, seg, total;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe la hora: ");
		hor = leer.nextInt();
		System.out.print("Escribe los minutos: ");
		min = leer.nextInt();		
		System.out.print("Escribe los segundos: ");
		seg = leer.nextInt();
		
		hor = hor * 60 * 60;
		min = min * 60;
		total = seg + min + hor;
		
		System.out.print("Has escrito un total de " + total + " segundos.");

		// leer.close(); 
	}
}
