package ejercicios05b;
// Método que retorne cuántas palabras de menos de 3 letras tiene una frase, 
// considerando como separador de palabras únicamente el inicio de cadena, 
// el espacio y el fin de cadena.

public class Ej14 {
	public static int cantidadDeCortas(String frase) {
		int cont = 0;
		frase = frase.trim().replaceAll(" +", " ");
		int pos = frase.indexOf(" ");
		int primer = 0;
		while(pos != -1) {
			if(frase.substring(primer, pos).length() <= 3) {
				cont++;
			}
			primer = pos + 1;
			pos = frase.indexOf(" ", pos + 1);
		}
		return cont;
	}
	
	public static void main(String[] args) {
		String frase = "    son las seis de la tarde";
		System.out.println(cantidadDeCortas(frase));
	}
}
