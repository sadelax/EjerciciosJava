package ejercicio06;

//Desarrollar un programa que se ejecute de la siguiente manera: 
// java … paquetes.Main usuario password Y verifique si el usuario existe en un 
// array y si su password coincide con el del usuario que estará cargado en otro 
// array en la misma posición. (Ver previamente parámetros desde la línea de comandos)

public class Ej10 {
	
	static String[] usuarios = {"user1", "pepe", "user2"};
	static String[] passwords = {"pwd1", "pwdpepe", "pwd2"};
	
	public static void main(String[] args) {
		if (args.length == 2) {
			if (check(args[0], args[1])) {
				System.out.println("Se ha identificado con exito!!!");
			}else {
				System.out.println("Identificación INCORRECTA");
			}
		} else {
			System.out.println("Debe ejecutar ejercicio06.Ej10 nombre_usario password");
		}
	}
	
	public static boolean check(String usr, String pwd) {
		int pos = buscarUsuario(usr);
		boolean correcto;
		if (pos != -1) {
			correcto = passwords[pos].equals(pwd);
		}else
			correcto = false;
		return correcto;
	}
	
	public static int buscarUsuario(String usr) {
		int encontrado = -1;
		for (int i = 0; i < usuarios.length && encontrado == -1; i++) {
			if (usuarios[i].equals(usr)) {
				encontrado = i;
			}
		}
		return encontrado;
	}
	
}
