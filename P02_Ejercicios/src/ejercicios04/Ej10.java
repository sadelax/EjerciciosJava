package ejercicios04;
// Solicite al usuario un número que represente el mes e imprima su nombre 
// y la cantidad de días que tiene (no contemplar años bisiestos).

public class Ej10 {
	public static void main(String[] arg) {
		System.out.println(nombreMes(7));
	}
	
	public static String nombreMes(int mes) {
		int dias = 0;
		String nombreMes = "";
		switch(mes) {
		case 1:
			nombreMes = "enero";
			dias = 31;
			break;
		case 2: 
			nombreMes = "febrero";
			dias = 28;
			break;
		case 3: 
			nombreMes = "marzo";
			dias = 31;
			break;
		case 4:
			nombreMes = "abril";
			dias = 30;
			break;
		case 5: 
			nombreMes = "mayo";
			dias = 31;
			break;
		case 6: 
			nombreMes = "junio";
			dias = 30;
			break;
		case 7: 
			nombreMes = "julio";
			dias = 31;
			break;
		case 8: 
			nombreMes = "agosto";
			dias = 31;
			break;
		case 9: 
			nombreMes = "septiembre";
			dias = 30;
			break;
		case 10: 
			nombreMes = "octubre";
			dias = 31;
			break;
		case 11: 
			nombreMes = "noviembre";
			dias = 31;
			break;
		case 12: 
			nombreMes = "diciembre";
			dias = 30;
			break;
		}
		return nombreMes + " tiene " + dias + " dias";
	}
}
