package ejercicios05b;
// Como el anterior, pero sin importar si es mayúscula o minúscula.

public class Ej04 {
	public static boolean empiezaPorH(String cadena) {
		return cadena.length() != 0 && (cadena.charAt(0) == 'h' || cadena.charAt(0) == 'H');
	}
	
	public static void main(String[] arg) {
		System.out.println(empiezaPorH("hola"));
		System.out.println(empiezaPorH("Hola"));
		System.out.println(empiezaPorH("mola"));
		System.out.println(empiezaPorH("caracoola"));
		System.out.println(empiezaPorH(" chhhola"));
	}
}
