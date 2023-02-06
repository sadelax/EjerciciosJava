package ejercicio05;

//Desarrollar un método que indique si una palabra es un palíndromo.
//a. Modificarlo para que indique si una frase es un palíndromo.
public class Ejercicio02 {
	public static void main(String[] args) {
		String frase = "Dabale arroz a la zorra el Abad";
		System.out.println(esPalindromoRec(frase));
	}
	
	public static boolean esPalindromoRec(String ori) {
		return esPalindromoRecPrivado(prepara(ori));
	}
	
	public static boolean esPalindromoRecPrivado(String ori) {
		if(ori.length() <= 1) return true;
		return ori.charAt(0) == ori.charAt(ori.length()-1) 
				&& esPalindromoRecPrivado(ori.substring(1,ori.length()-1));
	}

	public static boolean esPalindromo3(String ori) {
		ori = prepara(ori);
		boolean iguales = true;
		for (int i=0, d=ori.length()-1; i < d && iguales; i++, d--) {
			iguales = ori.charAt(i) == ori.charAt(d);
		}
		return iguales;
	}
	
	public static boolean esPalindromo2(String ori) {
		ori = prepara(ori);
		boolean iguales = true;
		int i = 0, d = ori.length()-1;
		while (i < d && iguales) {
			if (ori.charAt(i) != ori.charAt(d))
				iguales = false;
			i++;
			d--;
		}
		return iguales;
	}
	
	public static boolean esPalindromo(String ori) {
		ori = prepara(ori);
		return ori.equals(Ejercicio01.invierte(ori));
	}
	
	public static String prepara(String ori) {
		return ori.toLowerCase().replaceAll(" ", "");
	}
}
