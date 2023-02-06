package ejercicio05;

//Desarrolle un método que reciba una cadena con una expresión de una operación 
//  simple (+, -, *, /) con dos operandos y retorne el resultado como double

public class Ejercicio07b {
	public static void main(String[] args) {
		System.out.println("15 * 3 = " + calcula("15 * 3"));
		System.out.println("15.5 / 3 = " + calcula("15.5 / 3"));
		System.out.println("15.5 + 3.759 = " + calcula("15.5 + 3.759"));
		System.out.println("12 - 8.65 = " + calcula("12 - 8.65"));
	}
	
	public static double calcula(String operacion) {
		operacion = operacion.replaceAll(" ", "");
		double resu = 0;
		int pos = -1;
		
		int i=0;
		while(i < 4 && pos == -1) {
			pos = operacion.indexOf("+-*/".charAt(i));
			i++;
		}

		double num1 = Double.parseDouble(operacion.substring(0, pos));
		double num2 = Double.parseDouble(operacion.substring(pos+1));
		
		switch(i-1) {
		case 0:
			resu = num1 + num2;
			break;
		case 1:
			resu = num1 - num2;
			break;
		case 2:
			resu = num1 * num2;
			break;
		case 3:
			resu = num2 != 0 ? num1/num2 : 0;
		}
		return resu;
	}
}
