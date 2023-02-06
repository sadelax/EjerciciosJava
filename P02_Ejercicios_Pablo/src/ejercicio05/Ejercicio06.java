package ejercicio05;

//Desarrolle un método llamado capitalize que ponga en mayúsculas cada palabra de 
//  una frase recibida como parámetro. 
//  Por ej: si se recibe “Congreso internacional de programación de String”, 
//  debe devolver, “Congreso Internacional De Programación De String”. 
//  Utilice Character.toUpperCase(char c)
public class Ejercicio06 {
	public static void main(String[] args) {
		System.out.println(capitalize("    CongReso      internacional    de programación de String"));
		System.out.println(capitalize("HOLA"));
	}
	
	public static String capitalize(String str) {
		str = str.trim().replaceAll(" +", " ").toUpperCase();
		String resu = "" + str.charAt(0);
		int pos = str.indexOf(" ");
		int ant = 1;
		while (pos != -1) {
			resu += str.substring(ant, pos+1).toLowerCase() + str.charAt(pos + 1); 
			ant = pos + 2;
			pos = str.indexOf(" ", pos + 1);
		}
		resu += str.substring(ant).toLowerCase();
		return resu;
	}
}
