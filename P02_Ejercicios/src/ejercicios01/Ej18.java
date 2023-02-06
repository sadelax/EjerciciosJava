package ejercicios01;
import java.util.Scanner;

public class Ej18 {
	public static void main(String[] arg) {
		System.out.println("Distancia entre dos puntos.");
		
		double x1, x2, y1, y2, AA, BB, dist;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe las coordenadas del punto A: ");
		x1 = leer.nextDouble();
		y1 = leer.nextDouble();		
		System.out.print("Escribe las coordenadas del punto B: ");
		x2 = leer.nextDouble();
		y2 = leer.nextDouble();
		AA = x2 - x1;
		BB = y2 - y1;
		dist = Math.sqrt(Math.pow(AA, 2) + Math.pow(BB, 2));
		System.out.print("La distancia entre A y B es " + dist);
	}
}
