package ejercicios05b;
// Pedir al usuario una cadena y decir si empieza por el carácter ‘H’.

public class Ej03 {
	public static boolean empiezaPorH(String cadena) {
		boolean check = !(cadena.charAt(0) != 'H' && cadena.charAt(0) != 'h');
		return check;
	}
	
	public static void main(String[] arg) {
		System.out.println(empiezaPorH("hola"));
		System.out.println(empiezaPorH("Hola"));
		System.out.println(empiezaPorH("mola"));
		System.out.println(empiezaPorH("cola"));
		System.out.println(empiezaPorH("chola"));
	}
}
