package ejercicio05b;

//Método que pida un carácter c y un número n y que devuelva una cadena con c 
//  repetido n veces.
public class Ej05 {

	public static void main(String[] args) {
		System.out.println(repite('a', 5));
	}
	
	public static String repite(char c, int cant) {
		String resu = "";
		for (int i = 1; i <= cant; i++) {
			resu = resu + c;
		}
		return resu;
	}
}
