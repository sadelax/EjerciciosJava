package ejercicios05b;
// Programa que diga si una cadena dada por el usuario está o no vacía.

public class Ej02 {
	public static boolean cadenaVacia(String cadena) {
		boolean check = true;
		if(cadena.equals(""))
			check = false;
		return check;
	}
	
	public static void main(String[] arg) {
		if (cadenaVacia("hola") == true)
			System.out.println("la cadena no está vacía");
		else
			System.out.println("la cadena está vacía");
	}
}
