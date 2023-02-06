package ejercicios03;
import java.util.Scanner;

public class Ej04 {
	public static void main(String[] arg) {
		System.out.println("Adivinar el numero que ha pensado el usuario.");
		
		int num = 50, res;
		double aux = 50;
		String enter;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Piensa un numero del 1 al 100 y pulsa enter.");
		enter = leer.nextLine();
		System.out.print("Es el 50? Pulsa -1 si es menor, 1 si es mayor o 0 si he acertado. ");
		res = leer.nextInt();
		while(res != 0) {
			aux = Math.ceil(aux / 2);
			if(res < 0) {
				num -= aux;
				System.out.print("Es el " + num + "? Pulsa -1 si es menor, 1 si es mayor o 0 si he acertado. ");
				res = leer.nextInt();
			} else {
				num += aux;
				System.out.print("Es el " + num + "? Pulsa -1 si es menor, 1 si es mayor o 0 si he acertado. ");
				res = leer.nextInt();				
			}
		}
		System.out.print("Acierto!!!!!!111" + enter);
		
	}
}
