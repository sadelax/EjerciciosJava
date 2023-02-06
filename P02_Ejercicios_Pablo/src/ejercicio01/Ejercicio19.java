package ejercicio01;

import util.Util;

//Suponiendo que el primer día del año fue lunes, escribir un programa que reciba
// un número con el día del año (de 1 a 366) e imprima el día de la semana que 
// le toca. 
// Por ejemplo: 
//    si recibe 3 debe imprimir ’miércoles’, 
//    si recibe 9 debe imprimir ’martes’

public class Ejercicio19 {
	public static void main(String[] args) {
		int diaDelAnyo, dia;
		String nombreDia;
		
		Util.mostrar("Dia del Año");
		
		diaDelAnyo = Util.leerInt("Dia del año (1-365)");
		
		if (diaDelAnyo < 1 || diaDelAnyo > 365) {
			nombreDia = "incorrecto";
		} else {
			dia = diaDelAnyo % 7;

			switch (dia) {
			case 0:
				nombreDia = "Domingo";
				break;
			case 1:
				nombreDia = "Lunes";
				break;
			case 2:
				nombreDia = "Martes";
				break;
			case 3:
				nombreDia = "Miércoles";
				break;
			case 4:
				nombreDia = "Jueves";
				break;
			case 5:
				nombreDia = "Viernes";
				break;
			case 6:
				nombreDia = "Sábado";
				break;
			default:
				nombreDia = "";	
			}
		}
		Util.mostrar("El dia " + diaDelAnyo + " del año es " + nombreDia);
		Util.mostrar("El dia " + diaDelAnyo + " del año esta en la semana " + diaDelAnyo/7);
	}
}
