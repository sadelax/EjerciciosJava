package ejercicios01;
import java.util.Scanner;

public class Ej19 {
	public static void main(String[] arg) {
		System.out.println("Dias de la semana.");
		
		int dia, diaSem;
		String nombreDia = "";
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);

		System.out.print("Escribe un dia del 1 al 366: ");
		dia = leer.nextInt();
		
		diaSem = dia % 7;
		
		switch(diaSem) {
		case 0:
			nombreDia = "domingo";
			break;
		case 1:
			nombreDia = "lunes";
			break;
		case 2:
			nombreDia = "martes";
			break;
		case 3:
			nombreDia = "miercoles";
			break;
		case 4:
			nombreDia = "jueves";
			break;
		case 5:
			nombreDia = "viernes";
			break;
		case 6:
			nombreDia = "sabado";
			break;
		}
		System.out.print("El dia " + dia + " cae el " + nombreDia);
	}
}
