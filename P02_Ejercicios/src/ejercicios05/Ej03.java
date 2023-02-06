package ejercicios05;
// Desarrollar un método que, dada una cadena, retorne su sigla, es decir, 
// la primera letra de cada palabra en mayúsculas.
// Por ejemplo, si recibe ’Universal serial bus’ debe devolver ’USB’.
public class Ej03 {
	public static void main(String[] arg) {
		System.out.println(siglasDe(" Universal serial bus    "));
	}
	
	public static String siglasDe(String original) {
		String mayus = original.toUpperCase().replaceAll(" +", " ");
		String siglas = "" + mayus.charAt(0);
		
		int i = 0;
		while(i < original.length()) {
			if(original.charAt(i) == ' ')
				siglas += mayus.charAt(i + 1);
			i++;
		}
		return siglas.trim();
	}
}

// falta: y si hay espacios al final??