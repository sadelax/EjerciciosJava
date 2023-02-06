package ejercicio05b;

//Método que cuente el número de veces que aparece un carácter en una cadena.
public class Ej16 {

	public static void main(String[] args) {
		System.out.println(cuentaChar("rocococo", 'o'));
		System.out.println(cuentaChar("rocococo", 'c'));
		System.out.println(cuentaChar("rocococo", 'r'));
		System.out.println(cuentaChar("rocococo", 'x'));
	}
	
	public static int cuentaChar(String str, char c) {
		int cont = 0;
		int ant = str.indexOf(c);
		while(ant != -1) {
			cont++;
			ant = str.indexOf(c, ant + 1);
		}
		return cont;
	}
}
