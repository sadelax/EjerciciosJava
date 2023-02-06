package ejercicios03;
import java.util.Scanner;

public class Ej01 {
	public static void main(String[] arg) {
		System.out.println("Mayor y menor nota obtenida.");

		double nota, mayor, menor;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Ingresa una nota: ");
		nota = leer.nextDouble();
		mayor = nota;
		menor = nota;
		System.out.println("La nota mayor es " + mayor);
		
		while(nota >= 0) {
			System.out.print("Ingresa una nota: ");
			nota = leer.nextDouble();
			if(nota > mayor) {
				mayor = nota;
				System.out.println("La nota mayor es " + mayor);
			}
			if(nota < menor && nota == 0) {
				menor = nota;
				System.out.println("La nota menor es " + menor);
			}
		}		
	}
}
