package ejercicios05b;
// Método que reciba una cadena y la transforme sustituyendo todos los espacios por * (sin usar replace ni replaceAll).
public class Ej09 {
	public static void main(String[] args) {
		System.out.println(asteriscos("       hola que tal? yo bien venga hasta luego"));
		System.out.println(asteriscos("hola"));
	}
	public static String asteriscos(String cadena) {
		String nuevo = "";
		int pos = cadena.indexOf(' ');
		int i = 0;
		while(i < cadena.length() && pos == cadena.indexOf(' ')) {
			if(cadena.charAt(i) != ' ')
				nuevo += cadena.charAt(i);
			else
				nuevo += '*';
			i++;
		}
		return nuevo;
	}
}
