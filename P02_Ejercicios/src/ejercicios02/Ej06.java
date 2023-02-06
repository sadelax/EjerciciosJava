package ejercicios02;
import java.util.Scanner;

public class Ej06 {
	public static void main(String[] arg) {
		System.out.println("Calcular cuantos valores son mayores y menores a 0");
		
		int cant, cont = 0, pos = 0, neg = 0;
		double num;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Cantidad de numeros a calcular: ");
		cant = leer.nextInt();
		
		while(cont < cant) {
			System.out.print("Escribe un numero: ");
			num = leer.nextDouble();
			if(num >= 0)
				pos++;
			else
				neg++;
			cont++;
		}
		System.out.print("De " + cant + " numeros que has ingresado, " + pos + " son mayor o igual que 0 y " + neg + " son menores que 0.");		
	}
}
