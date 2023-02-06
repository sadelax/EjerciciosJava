package ejercicios05b;
// Repite el ejercicio anterior usando indexOf.
public class Ej10a {
	public static void main(String[] args) {
		System.out.println(recortada("hola", 'd'));
		System.out.println(recortada("quedan macarrones", 'd'));
	}
	public static String recortada(String cadena, char c) {
		String nuevo = "";
		for(int i = 0; i < cadena.indexOf(c); i++) {
			nuevo += cadena.charAt(i);
		}
		return nuevo;
	}
}
