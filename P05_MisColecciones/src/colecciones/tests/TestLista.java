package colecciones.tests;

import colecciones.listas.Lista;
import colecciones.listas.ListaArray;

public class TestLista {
	
	public static void main(String[] args) {
		
		ListaArray la = new ListaArray(2);
		la.agregar("primero");
		la.agregar("segundo");
		la.agregar("tercero");
		la.agregar("cuarto");
		la.agregar("quinto");
		ListaArray le = new ListaArray(2);
		le.agregar("primero");
		le.agregar("segundo");
		le.agregar("tercero");
		le.agregar("cuarto");
		le.agregar("quinto");
		
		
		recorre(la);
		System.out.println("");
		recorre(le);
		System.out.println("");
		System.out.println(le.buscar(2));
	}
	
	public static void recorre(Lista lista) {
		for (int i = 0; i <lista.tamanyo(); i++) {
			System.out.println(lista.buscar(i));
		}
	}
}
