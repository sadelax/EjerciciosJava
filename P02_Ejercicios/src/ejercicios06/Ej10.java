package ejercicios06;
// Desarrollar un programa que se ejecute de la siguiente manera: 
// java … paquetes.Main usuario password Y verifique si el usuario existe en un array 
// y si su password coincide con el del usuario que estará cargado en otro array en la misma posición. 
// (Ver previamente parámetros desde la línea de comandos)

public class Ej10 {
	static String[] user = {"paola", "nacho", "mariang"};
	static String[] pwd = {"123", "abc", "qwertyuiop[]"};
	
	public static void main(String[] args) {
		boolean check = false;
		if(args.length == 2) {
			for(int i = 0; i < args.length; i++) {
				if(args[0].equals(user[i]) && args[1].equals(pwd[i])) {
					check = true;
				}
			}			
		} else {
			check = false;
		}
		
		if(check == true) {
			System.out.println("todo correcto");
		} else {
			System.out.println("meeeeeeeeec");
		}
	}
}
