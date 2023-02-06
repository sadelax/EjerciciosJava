package ejercicios05;
// Desarrolle un método llamado capitalize que ponga en mayúsculas 
// cada palabra de una frase recibida como parámetro. 
// Por ej: si se recibe “Congreso internacional de programación de String”, debe devolver: 
// “Congreso Internacional De Programación De String”. Utilice Character.toUpperCase(char c)
public class Ej06 {
	public static void main(String[] arg) {
		System.out.println(capitalize("     congreso internacional de programación de String  "));
	}
	public static String capitalize(String frase) {
		frase = frase.trim().replaceAll(" +", " ");
		String prep = "" + Character.toUpperCase(frase.charAt(0));
		
		for(int i = 1; i < frase.length(); i++) {
			prep += frase.charAt(i);
			if(frase.charAt(i) == ' ') {
				i++;
				prep += Character.toUpperCase(frase.charAt(i));				
			}
		}
		return prep;
	}
}
