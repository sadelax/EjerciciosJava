package ejercicios01;
import java.util.Scanner;

public class Ej03 {
	public static void main(String[] arg) {
		System.out.println("Calcular perímetro y área de un círculo");
		
		double radio, perimetro, area;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe radio: ");
		radio = leer.nextDouble();
			
		if(radio > 0) {
			perimetro = 2 * Math.PI * radio;
			area = Math.PI * Math.pow(radio, 2);
				
			System.out.println("El perimetro es " + perimetro);
			System.out.println("El área es " + area);
		} else System.out.println("El radio no puede ser negativo");
	}
}