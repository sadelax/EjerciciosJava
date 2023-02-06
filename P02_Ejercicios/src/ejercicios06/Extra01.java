package ejercicios06;
import java.util.Scanner;
// Armar las estructuras necesarias para leer por pantalla los siguientes datos:
//Nombre del alumno, nota examen modulo 1, nota examen modulo 2, cantidad de
//inasistencias. Almacenar de cada uno su nota media.
//Hacer un menú que permita las siguientes opciones:


public class Extra01 {
	String[] nombres = new String[10];
	int[] id = new int[10];
	double[] notas1 = new double[10];
	double[] notas2 = new double[10];
	int[] faltas = new int[10];
	static int cant = 0;
	
	static Scanner leer = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion;
		String menu = """
				Sistema de Gestión de Alumnos
				1 – Agregar alumnos y con sus notas e inasistencias.
				2 – Buscar un alumno por id (posición en el array) y mostrar toda su información.
				3 – Buscar un alumno por nombre y mostrar toda su información.
				4 – Listar todos los alumnos y toda su información.
				5 – Mostrar el/los alumnos con mayor nota media.
				6 – Mostrar los alumnos con nota media >= 5.
				7 – Mostrar los alumnos con más de 3 inasistencias.
				9 – Salir.
				""";
		
		do {
			System.out.println(menu);
			System.out.print("> ");
			opcion = leer.nextInt();
			if(opcion >= 1 && opcion <= 7) {
				procesaMenu(opcion);
			}
		} while(opcion != 9);
	}
	
	public static void procesaMenu(int opcion) {
//		switch(opcion) {
//		case 1:
//			agrega();
//		case 2:
//			buscarPorId();
//		case 3:
//			buscarPorNombre();
//		case 4:
//			listarAlumnos();
//		case 5:
//			alumnosMayorNota();
//		case 6:
//			alumnosAprobados();
//		case 7:
//			alumnosConFaltas();
//		case 9:
//			salir();
//		}
	}

}
