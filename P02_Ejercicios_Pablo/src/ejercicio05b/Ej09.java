package ejercicio05b;

//Método que reciba una cadena y la transforme sustituyendo todos los espacios por * 
//  (sin usar replace ni replaceAll).
public class Ej09 {
	
	public static void main(String[] args) {
		System.out.println(reemplaza("esto es una frase "));
	}

	public static String reemplaza(String str) {
		String resu = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') 
				resu += "*";
			else
				resu = resu + str.charAt(i);
		}
		return resu;
	}
}
