package ejercicios01;
import java.util.Scanner;

public class Ej15 {
	public static void main(String[] arg) {
		System.out.println("Calcular la hipotenusa de un triangulo.");
		
		double cat1, cat2, hip;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe la longitud de un cateto: ");
		cat1 = leer.nextDouble();
		System.out.print("Escribe la longitud del otro cateto: ");
		cat2 = leer.nextDouble();
		
		hip = Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));

		System.out.print("La hipotenusa mide " + hip);
	}

}
