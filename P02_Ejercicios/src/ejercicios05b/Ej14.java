package ejercicios05b;
// Método que retorne cuántas palabras de menos de 3 letras tiene una frase, 
// considerando como separador de palabras únicamente el inicio de cadena, el espacio y el fin de cadena.

public class Ej14 {
	public static int cantidadDeCortas(String frase) {
		int cont = 0;
		frase = frase.trim().replaceAll(" +", " ");
		int pos = frase.indexOf(" ");
		
		for(int i = 0; i < frase.length(); i++) {
			
		}
		return cont;
	}
	
	public static void main(String[] args) {
		String frase = "    son las seis de la tarde";
		System.out.println(cantidadDeCortas(frase));
	}
}
