package ejercicios01;
import java.util.Scanner;

public class Ej12 {
	public static void main(String[] arg) {
		System.out.println("Sumar dos tiempos.");
		
		int hh, mm, ss, tiempoA, tiempoB, sumaSeg;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe hora: ");
		hh = leer.nextInt();
		System.out.print("Escribe minutos: ");
		mm = leer.nextInt();
		System.out.print("Escribe segundos: ");
		ss = leer.nextInt();
		
		hh = hh * 60 * 60;
		mm = mm * 60;
		tiempoA = ss + mm + hh;
		
		System.out.print("Escribe hora: ");
		hh = leer.nextInt();
		System.out.print("Escribe minutos: ");
		mm = leer.nextInt();
		System.out.print("Escribe segundos: ");
		ss = leer.nextInt();
		
		hh  *= 60 * 60;
		mm *= 60;
		tiempoB = ss + mm + hh;
		
		sumaSeg = tiempoA + tiempoB;
		
		mm = sumaSeg / 60;
		ss = sumaSeg % 60;
		hh = mm / 60;
		mm %= 60;
		
		System.out.print("El total de los dos tiempos en segundos es "
				+ hh + " horas, " + mm + " minutos y " + ss + " segundos.");
	}
}
