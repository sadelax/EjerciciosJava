package ejercicio05b;

//Método que reciba dos cadenas y las junte carácter a carácter. Es decir, 
//  si recibe “pata” y “coco” el resultado es “pcaotcao”. 
//  Las cadenas tienen que ser del mismo tamaño.
//    a. Mejorar el anterior para que no importe que las palabras sean de distinto 
//       tamaño. Es decir, si recibe “patata” y “coco” el resultado sería “pcaotcaota”, 
//       añadiendo la cadena sobrante directamente al final.

public class Ej15 {

	public static void main(String[] args) {
		System.out.println(juntar("patata", "cococo"));
		System.out.println(juntarA("patata", "cococo"));
		System.out.println(juntarA("patata", "coco"));
		System.out.println(juntarA("coco", "patata"));
	}
	
	public static String juntar(String str1, String str2) {
		String resu = "";
		for (int i = 0; i < str1.length(); i++) {
			resu = resu + str1.charAt(i) + str2.charAt(i);
		}
		return resu;
	}
	
	public static String juntarA(String str1, String str2) {
		String resu = "";
		int mayor = Math.max(str1.length(), str2.length());
		for (int i = 0; i < mayor; i++) {
			resu += i < str1.length() ? str1.charAt(i) : "";
			resu += i < str2.length() ? str2.charAt(i) : "";
		}
		return resu;
	}
}
