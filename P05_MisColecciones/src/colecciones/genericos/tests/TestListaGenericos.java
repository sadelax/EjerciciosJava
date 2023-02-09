package colecciones.genericos.tests;

import colecciones.genericos.listas.Lista;
import colecciones.genericos.listas.ListaArray;

public class TestListaGenericos {
	public static void main(String[] args) {
	
		ListaArray<Integer> la = new ListaArray<Integer>();
		la.agregar(45);
		la.agregar(991);
		la.agregar(65);
		la.agregar(543);
		la.agregar(12);
		la.agregar(32);
		
		ListaArray<Integer> le = new ListaArray<Integer>();
		le.agregar(45);
		le.agregar(991);
		le.agregar(65);
		le.agregar(543);
		le.agregar(12);
		le.agregar(32);
		
		recorre(la);
		System.out.println();
		recorre(le);	
	}
	
	public static void recorre(Lista<Integer> lista) {
		for (int i = 0; i < lista.tamanyo(); i++) {
			System.out.println(lista.buscar(i));
		}
	}
}
