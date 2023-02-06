package ejercicios04;
import java.util.Scanner;
// Repetir el ejercicio anterior, pero ingresando un número entero de cualquier cantidad de cifras.
public class Ej05 {
	public static void main(String[] arg) {
		int num, len = 0, aux = 0;
		System.out.print("Ingresa un numero: ");
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		num = leer.nextInt();
		aux = num;
		while (aux > 0) {
			aux /= 10;
			len++;
			System.out.println("len"+len);
		}
		while (len > 0) {
			len--;
			aux = num / (int)Math.pow(10, len);
			System.out.println(aux % 10);
		}
	}
}
