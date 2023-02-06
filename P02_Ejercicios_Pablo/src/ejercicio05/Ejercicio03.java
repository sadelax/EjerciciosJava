package ejercicio05;

//Desarrollar un método que, dada una cadena, retorne su sigla, es decir, 
//  la primera letra de cada palabra en mayúsculas. 
//  Por ejemplo, si recibe ’Universal serial bus’ debe devolver ’USB’.

public class Ejercicio03 {
	
	public static void main(String[] args) {
		String original = "   Universal   serial   bus   ";
		
		System.out.println(sigla(original));
	}
	
	public static String sigla (String str) {
		str = " " + str.trim().replaceAll(" +", " ");
		String sigla = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				sigla += str.charAt(i+1);
		}
		return sigla.toUpperCase();
	}
	
	public static String sigla2(String str) {
		str = str.trim().replaceAll(" +", " ");
		String sigla = "" + str.charAt(0);
		int pos = str.indexOf(" ");
		while (pos != -1) {
			sigla += str.charAt(pos + 1);
			pos = str.indexOf(" ", pos + 1);
		}
		return sigla.toUpperCase();
	}
}




