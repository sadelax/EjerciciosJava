package ejercicio05b;

//Método que retorne cuántas palabras de menos de 3 letras tiene una frase, 
//  considerando como separador de palabras únicamente el inicio de cadena, 
//  el espacio y el fin de cadena.

public class Ej14 {

	public static void main(String[] args) {
		System.out.println(cuentaPalabras3("  En un lugar   de la mancha  cuyo 123  "));
	}
	
	public static int cuentaPalabras3(String str) {
		str = str.trim().replaceAll(" +", " ");
		int cont = 0;
		int ant = 0;
		int pos = str.indexOf(" ");
		while(pos != -1) {
			if (str.substring(ant, pos).length() <= 3)
				cont++;
			ant = pos + 1;
			pos = str.indexOf(" ", pos + 1);
		}
		if (str.substring(ant).length() <= 3)
			cont++;
		return cont;
	}
}
