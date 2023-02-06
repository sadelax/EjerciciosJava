package ejercicios01;
import java.util.Scanner;

public class Ej17 {
	public static void main(String[] arg) {
		System.out.println("Calcular capital final.");
		
		double capInit, intAn, tiempo, cap, capFin;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Ingresa capital inicial");
		capInit = leer.nextDouble();
		System.out.print("Ingresa intereses anuales");
		intAn = leer.nextDouble();
		System.out.print("Ingresa capitalizacion ");
		cap = leer.nextDouble();
		System.out.print("Ingresa tiempo hasta retirar");
		tiempo = leer.nextDouble();
		capFin = Math.pow(capInit * (1 + (intAn / cap)), (cap * tiempo));
		System.out.print("El capital final es " + capFin);
	}
}
