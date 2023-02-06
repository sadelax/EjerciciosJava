package ejercicios03;
import java.util.Scanner;

public class Ej02 {
	public static void main(String[] arg) {
		System.out.println("Numeros reales a peticion.");
		
		double num, ult, mayor, menor;
		int cont = 1;
		char res;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un numero: ");
		num = leer.nextDouble();
		ult = num;
		mayor = num;
		menor = num;
		System.out.print("Quieres escribir mas numeros? ");
		res = leer.next().charAt(0);
		while(res == 's') {
			System.out.print("Escribe un numero: ");
			num = leer.nextDouble();
			if(num > mayor)
				mayor = num;
			if(num < menor)
				menor = num;
			System.out.print("Quieres escribir mas numeros? ");
			res = leer.next().charAt(0);
			cont++;
		}
		if(res == 'n'){
			System.out.println("La cantidad de valores ingresados es " + cont);
			System.out.println("El primer valor ingresado es " + ult);
			System.out.println("El ultimo valor ingresado es " + num);
			System.out.println("El mayor valor ingresado es " + mayor);
			System.out.println("El menor valor ingresado es " + menor);
		}
	}
}