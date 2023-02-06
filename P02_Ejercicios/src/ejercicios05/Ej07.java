package ejercicios05;
// Desarrolle un método que reciba una cadena con una expresión de una operación simple (+, -, *, /)
// con dos operandos y retorne el resultado como double.
public class Ej07 {
	public static void main(String[] arg) {
		System.out.println(operacion("5 + 6"));
		System.out.println(operacion("6 -1"));
		System.out.println(operacion("5 * 6"));
		System.out.println(operacion("10 / 2"));
	}
	
	public static double operacion(String cadena) {
		cadena = cadena.replace(" ", "");
		int op = '+';
		double res = 0;
		if (cadena.indexOf('+') > -1)
			op = '+';
		else if(cadena.indexOf('-') > -1)
			op = '-';
		else if(cadena.indexOf('*') > -1)
			op = '*';
		else if(cadena.indexOf('/') > -1)
			op = '/';
		double n1 = Double.parseDouble(cadena.substring(0, cadena.indexOf(op)));
		double n2 = Double.parseDouble(cadena.substring(cadena.indexOf(op) + 1, cadena.length()));
		if(op == '+')
			res = n1 + n2;
		else if (op == '-')
			res = n1 - n2;
		else if (op == '*')
			res = n1 * n2;
		else if (op == '/')
			res = n2 != 0 ? n1 / n2 : 0;
		
		return res;
	}
}