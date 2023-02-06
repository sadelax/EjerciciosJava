package ejercicios01;
import java.util.Scanner;

public class Ej02 {
	public static void main(String[] args) {
		System.out.println("Calcular perímetro y área de un triángulo.");
		
		double largo, ancho, area, perimetro;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Introduce largo: ");
		largo = leer.nextDouble();
		System.out.println("Introduce ancho: ");
		ancho = leer.nextDouble();
		
		perimetro = 2 * largo + 2 * ancho;
		area = (largo * ancho);
			
		System.out.println("El perímetro es " + perimetro);
		System.out.println("El área es " + area);

	}
}
