package ejercicios04;
import java.util.Scanner;

// Solicite al usuario un número que represente el mes e imprima su nombre.
public class Ej09 {
	public static void main(String[] arg) {
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese numero: ");
		int num = leer.nextInt();
		String mes = "";
		switch(num) {
			case 1: mes = "enero";
			break;
			case 2: mes = "febrero";
			break;
			case 3: mes = "marzo";
			break;
			case 4: mes = "abril";
			break;
			case 5: mes = "mayo";
			break;
			case 6: mes = "junio";
			break;
			case 7: mes = "julio";
			break;
			case 8: mes = "agosto";
			break;
			case 9: mes = "septiembre";
			break;
			case 10: mes = "octubre";
			break;
			case 11: mes = "noviembre";
			break;
			case 12: mes = "diciembre";
			break;
		}
		System.out.println(mes);
	}
}
