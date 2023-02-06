package ejercicios05;

public class Ej02a {
	public static void main(String[] arg) {
		System.out.println(esPalindromo2("dabale arroz a ffla zorra el abad"));
	}
	
	public static boolean esPalindromo2(String original) {
		String lower = original.toLowerCase().replace(" ", "");
		
		return Ej02.esPalindromo(lower);
	}
}
