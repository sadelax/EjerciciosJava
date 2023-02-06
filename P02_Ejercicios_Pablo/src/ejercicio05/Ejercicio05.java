package ejercicio05;

//Desarrollar un método que reciba una cadena e inserte un carácter cada 
//  3 caracteres. Por ejemplo: “1921680012” y ‘.’, debe retornar “192.168.001.2”
//    a. Haga otra versión del método, pero que reciba una cadena, un carácter 
//    y la cantidad de dígitos entre las que se debe insertar el carácter.

public class Ejercicio05 {
	public static void main(String[] args) {
		System.out.println(inserta("1921681567", '.', 3));
	}
	
	public static String inserta(String str, char sep, int cant) {
		String resu = "";
		int ant = 0;
		for (int i = cant; i < str.length(); i+=cant) {
			resu += str.substring(ant, i) + sep;
			ant = i;
		}
		resu += str.substring(ant);
		return resu;
	}
}
