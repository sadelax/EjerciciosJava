package ejercicios01;
import java.util.Scanner;

public class Ej05 {
	public static void main(String[] arg) {
		System.out.println("Calcular el volumen de una esfera.");
		
		double radio, volumen;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Ingresa radio: ");
		radio = leer.nextDouble();
			
		volumen = 4 / 3 * Math.PI * Math.pow(radio, 3);
			
		System.out.print("Volumen = " + volumen);
	}
}
