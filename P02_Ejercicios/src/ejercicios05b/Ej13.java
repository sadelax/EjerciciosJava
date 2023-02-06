package ejercicios05b;
// Método que reciba una cadena y comprueba si el balanceo de paréntesis es correcto (se abren y se cierran correctamente).
public class Ej13 {
	public static void main(String[] args) {
		System.out.println(balanceo("()"));				// true
		System.out.println(balanceo("(hola)"));			// true
		System.out.println(balanceo("())"));			// false
		System.out.println(balanceo("(hola"));			// false
		System.out.println(balanceo("(hola(HOLA))"));	// true
		System.out.println(balanceo(")hola(HOLA))"));	// false
	}
	public static boolean balanceo(String cadena) {
		boolean check = false;
		int cont = 0;
		boolean aper = true;
		boolean cier = true;
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i) == '(') {
				cont++;
				aper = true;
			}
			if(cadena.charAt(i) == ')') {
				cont++;
				cier = true;
			}
		}
		if(cont % 2 == 0 && aper && cier)
			check = true;
		return check;
	}
}
