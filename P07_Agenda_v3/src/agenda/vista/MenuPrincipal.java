package agenda.vista;

import java.util.Scanner;

import agenda.modelo.Contacto;
import agenda.negocio.Agenda;
import agenda.negocio.AgendaImpl;

public class MenuPrincipal {
	
	private Agenda neg = new AgendaImpl();
	
	private Scanner tec = new Scanner(System.in);
	
	public MenuPrincipal() {
		menu();
	}

	private void menu() {
		System.out.println("Super Agenda 86");
		System.out.println("---------------");
		
		boolean salir = false;
		int opcion;
		do {
			System.out.println("menu principal");
			System.out.println("1 - nuevo contacto");
			System.out.println("2 - buscar contacto");
			System.out.println("9 - salir");
			System.out.print("> ");
			opcion = Integer.parseInt(tec.nextLine());
			
			switch(opcion) {
			case 1:
				nuevo();
				break;
			case 2:
				buscar();
				break;
			case 9:
				salir = true;
				break;
			default:
				break;
			}
			
		} while(!salir);
	}
	
	private void nuevo() {
		System.out.println("\nNuevo Contacto");
		System.out.println("Ingresa los datos del nuevo contacto.");
		System.out.print("Nombre: ");
		String nom = tec.nextLine();
		System.out.print("Apellidos: ");
		String ape = tec.nextLine();
		System.out.print("Apodo: ");
		String apodo = tec.nextLine();
		
		Contacto nuevo = new Contacto();
		nuevo.setNombre(nom);
		nuevo.setApellidos(ape);
		nuevo.setApodo(apodo);
		
		neg.insertarContacto(nuevo);
	}
	private void buscar() {
		System.out.println("buscar");
	}
}
