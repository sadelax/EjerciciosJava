package ejercicio05;

// Desarrollar un método que reciba una cadena y un carácter e inserte el 
//   carácter entre cada letra de la cadena. 
//   Ej: “separar” y ’-’ debería retornar “s-e-p-a-r-a-r”

public class Ejercicio04 {
	public static void main(String[] args) {
		System.out.println(separa("algomaslargo", '.'));
		System.out.println(separa("algomaslargo"));
	}
	
	public static String separa(String str) {
		return separa(str,'-');
	}
	
	public static String separa(String str, char sep) {
		String separado = "" + str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			separado += "" + sep + str.charAt(i);
		}
		return separado;
	}
	
	
}
