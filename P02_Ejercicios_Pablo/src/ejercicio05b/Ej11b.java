package ejercicio05b;

//Pedir una frase y eliminar las vocales. No se puede usar replace ni replaceAll.
//   Repite el ejercicio anterior usando replace
public class Ej11b {
	
	public static void main(String[] args) {
		System.out.println(eliminaVocales("Hola"));
		System.out.println(eliminaVocales("murcielago"));
	}

	public static String eliminaVocales(String str) {
		return str.replaceAll("[aeiouAEIOU]", "");
	}
}
