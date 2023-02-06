package ejercicio05b;

//Pedir una frase y eliminar las vocales. No se puede usar replace ni replaceAll.
public class Ej11a {
	
	public static void main(String[] args) {
		System.out.println(eliminaVocales("Hola"));
		System.out.println(eliminaVocales("murcielago"));
	}

	public static String eliminaVocales(String str) {
		String resu = "";
		for (int i = 0; i < str.length(); i++) {
			char c = Character.toLowerCase(str.charAt(i));
			if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'))
				resu = resu + str.charAt(i);
		}
		return resu;
	}
}
