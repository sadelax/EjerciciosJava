package ejercicio05b;

//Método que elimina los caracteres en blanco al principio de una cadena. 
//   No puedes usar trim.
// a. Otro que elimine los caracteres en blanco finales de una cadena. 
//   No puedes usar trim.
// b. Otro que quite los caracteres en blanco a la izquierda y a la derecha de una cadena. No puedes usar trim.
public class Ej17 {

	public static void main(String[] args) {
		System.out.println("-" + trimPrincipio("") + "-");
		System.out.println("-" + trimPrincipio("    ") + "-");
		System.out.println("-" + trimPrincipio("hola") + "-");
		System.out.println("-" + trimPrincipio("      hola") + "-");

		System.out.println("-" + trimFinal("-" + "" + "-") + "-");
		System.out.println("-" + trimFinal("    ") + "-");
		System.out.println("-" + trimFinal("hola") + "-");
		System.out.println("-" + trimFinal("      hola    ") + "-");
		
		System.out.println("-" + trim("-" + "" + "-") + "-");
		System.out.println("-" + trim("    ") + "-");
		System.out.println("-" + trim("hola") + "-");
		System.out.println("-" + trim("      hola    ") + "-");
	}
	
	public static String trim(String str) {
		return trimPrincipio(trimFinal(str));
	}
	
	public static String trimPrincipio(String str) {
		int desde = 0;
		while(desde < str.length() && str.charAt(desde) == ' ')
			desde++;
		return str.substring(desde);
	}
	
	public static String trimFinal(String str) {
		int hasta = str.length() - 1;
		while(hasta >= 0 && str.charAt(hasta) == ' ')
			hasta--;
		return str.substring(0, hasta + 1);
	}
}
