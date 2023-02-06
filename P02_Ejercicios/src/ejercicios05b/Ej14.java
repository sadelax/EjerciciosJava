package ejercicios05b;
// Método que retorne cuántas palabras de menos de 3 letras tiene una frase, 
// considerando como separador de palabras únicamente el inicio de cadena, el espacio y el fin de cadena.

public class Ej14 {
	public static int cantidadDeCortas(String frase) {
		int cont = 0;
		int cant = 0;
		for(int i = 0; i < frase.length(); i++) {
			if(frase.charAt(i) != ' ' && cont < 3) {
				cont++;
				System.out.println("cont"+cont);
			}
		}
		return cant;
	}
	
	public static void main(String[] args) {
		String frase = "son las seis de la tarde";
//		String aaa = "a aa aa aaa aaaa aaaaa";
//		String a = "a a a a a a a a";
		System.out.println(cantidadDeCortas(frase));
//		System.out.println(cantidadDeCortas(aaa));
//		System.out.println(cantidadDeCortas(a));
	}
}
