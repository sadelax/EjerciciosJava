package ejercicios05;

public class Ej02 {
	public static void main(String[] arg) {
		System.out.println(esPalindromo("dabalearrozalazorraelabad"));
	}
	
	public static boolean esPalindromo(String original) {
		boolean res = true;
		for (int i = 0, j = original.length()-1; i < j && res; i++, j--) {
			res = original.charAt(i) == original.charAt(j);
		}
		return res;
	}
}
