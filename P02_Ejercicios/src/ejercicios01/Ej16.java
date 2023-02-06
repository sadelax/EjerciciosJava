package ejercicios01;
import java.util.Scanner;

public class Ej16 {
	public static void main(String[] arg) {
		System.out.println("Calcular formula de interes.");
		
		double capInic, intAnual, tiempo, total;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe capital inicial");
		capInic = leer.nextDouble();		
		System.out.print("Escribe interes anual");
		intAnual = leer.nextDouble();
		System.out.print("Escribe tiempo a retirar capital");
		tiempo = leer.nextDouble();
		
		total = capInic * intAnual * tiempo;
		
		System.out.print("El monto final a obtener es " + total);
	}
}
