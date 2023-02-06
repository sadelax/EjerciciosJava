package ejercicio05b;

//Pedir al usuario una frase y un carácter, y decir en qué posiciones está ese 
//  carácter, o indicar que no está si procede. No se puede usar indexOf o similar.
//     Repite el ejercicio anterior, pero usando indexOf
public class Ej07b {
	
	public static void main(String[] args) {
		System.out.println(indexOf("Hola que tal", 'q'));
		System.out.println(indexOf("Hola que tal", 'x'));
	}
	
	public static int indexOf(String str, char c) {
		return str.indexOf(c);
	}
}
