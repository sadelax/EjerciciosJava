package ejercicio06;

import java.util.Scanner;

public class Ej11_Extra {
	static String[] alumnos = new String[10];
	static double[] nota1 = new double[10];
	static double[] nota2 = new double[10];
	static double[] notasMedia = new double[10];
	static int[] inasistencias = new int[10];
	static int cant = 0;
	
	static Scanner tec = new Scanner(System.in);
	
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
			System.out.println(">");
			opcion = tec.nextInt();
			if (opcion >= 1 && opcion <= 7) {
				procesaMenu(opcion);
			}
		}while(opcion != 9);
	}
	
	public static void procesaMenu(int opcion) {
		switch(opcion) {
		case 1:
			agrega();
			break;
		case 2:
			buscarPorId();
			break;
		case 3:
			buscarPorNombre();
			break;
		case 4:
			listarTodos();
			break;
		case 5:
			listarMayorNota();
			break;
		case 6:
			listarAprobados();
			break;
		case 7:
			listarInasistencias();
			break;
		}
	}
	
	public static void agrega() {
		if (cant >= alumnos.length) {
			redimensiona();
		}
		
	}
	
	public static void buscarPorId() {
	}
	
	public static void buscarPorNombre() {
	}
	
	public static void listarTodos() {
	}
	
	public static void listarMayorNota() {
	}
	
	public static void listarAprobados() {
	}
	
	public static void listarInasistencias() {
	}
	
	public static void redimensiona() {
		
	}
}
