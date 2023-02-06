package ejercicios01;
import java.util.Scanner;

public class Ej11 {
	public static void main(String[] arg) {
		System.out.println("Obtener formato hh, mm, ss.");
		
		int hh, mm, ss, tiempo;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe un tiempo en segundos: ");
		tiempo = leer.nextInt();
		
		mm = tiempo / 60;
		ss = tiempo % 60;
		hh = mm / 60;
		mm %= 60;
		
		System.out.print(tiempo + " segundos son " + hh + " horas, " + mm + " minutos " + ss + " segundos.");
	}
}
