package ejercicios03;
import java.util.Scanner;

public class Ej05 {
	public static void main(String[] arg) {
		System.out.println("Conversor de divisas.");
		
		double euro, dolar, libra, yen, can;
		String div;
		
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		
		System.out.print("Escribe la cantidad en euros: ");
		euro = leer.nextDouble();		
		System.out.print("A que divisa quieres convertir? ");
		div = leer.next();
		
		switch(div) {
		case "dolares":
			dolar = euro / 0.88;
			System.out.print(euro + " euros son " + dolar + " dolares.");
			break;
		case "libras":
			libra = euro / 1.2;
			System.out.print(euro + " euros son " + libra + " libras esterlinas.");
			break;
		case "yenes":
			yen = euro / 0.0077;
			System.out.print(euro + " euros son " + yen + " yenes.");
			break;
		case "canadienses":
			can = euro / 0.71;
			System.out.print(euro + " euros son " + can + " dolares canadienses.");
			break;
		}

		// leer.close();
	}
}
