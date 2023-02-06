package ejercicios02;
import java.util.Scanner;

public class Ej09 {
	public static void main(String[] arg) {
		System.out.println("Obtener cantidad de numeros ingresados, la suma, la cantidad de numeros positivos y negativos, cantidad de numeros pares e impares, el mayor y su posicion, el menor y su posicion, y la media.");
		
		int cant, cont = 1, acum = 0, pos = 0, neg = 0, par = 0, impar = 0, posMay = 1, posMen = 1;
		double num, mayor, menor;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Inserta la cantidad de numeros a procesar: ");
		cant = leer.nextInt();
		System.out.print("Ingresa un numero: ");
		num = leer.nextDouble();
		
		if(num % 2 == 0)
			par++;
		else
			impar++;
		if(num >= 0)
			pos++;
		else
			neg++;

		acum += num;
		mayor = menor = num;
		
		while(cant > cont) {
			cont++;
			System.out.print("Ingresa un numero: ");
			num = leer.nextDouble();
			acum += num;
			if(num >= 0)
				pos++;
			else
				neg++;
			if(num % 2 == 0)
				par++;
			else
				impar++;
			if(num > mayor) {
				mayor = num;
				posMay = cont;
			}
			if(num < menor) {
				menor = num;
				posMen = cont;
			}
		}
		System.out.println("Cantidad de nos. Ingresados: " + cont);
		System.out.println("Sumatoria: " + acum);
		System.out.println("Cantidad de nros positivos o 0: " + pos);
		System.out.println("Cantidad de nros negativos: "+ neg);
		System.out.println("Cantidad de nros pares: " + par);
		System.out.println("Cantidad de nros impares: " + impar);
		System.out.println("Mayor valor: " + mayor + " = ingresado en el lugar: " + posMay);
		System.out.println("Menor valor: " + menor + " = ingresado en el lugar: " + posMen);
	}
}
