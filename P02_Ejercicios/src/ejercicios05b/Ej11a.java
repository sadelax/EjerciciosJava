package ejercicios05b;
// Repite el ejercicio anterior usando replace
public class Ej11a {
	public static void main(String[] args) {
		System.out.println(sinVocales("sin vocales aqui por favor"));
	}
	public static String sinVocales(String frase) {
		return frase.replaceAll("[aeiou]", "");
	}
}
