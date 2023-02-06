package ejercicio05;

//Desarrollar un método que reciba una cadena y retorne otra con la original invertida.
public class Ejercicio01 {

	public static void main(String[] args) {
		System.out.println(invierte("Hola que tal"));
		System.out.println(invierte2("Hola que tal"));
	}
	
	public static String invierte(String ori) {
		String inv = "";
		for (int i = ori.length() - 1; i >= 0; i--) {
			inv += ori.charAt(i);
		}
		return inv;
	}
	
	public static String invierte2(String ori) {
		String inv = "";
		for (int i = 0; i < ori.length(); i++) {
			inv = ori.charAt(i) + inv;
		}
		return inv;
	}

}
