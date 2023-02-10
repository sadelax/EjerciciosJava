package listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		LinkedList<String> ll = new LinkedList<>();
		final int CANT = 500_000;
		
		cargaLista(al, CANT);
		cargaLista(ll, CANT);

		long t0 = System.currentTimeMillis();	 
		recorreIterador(al);
		long tf = System.currentTimeMillis();	 
		System.out.println("ArrayList con Iterator " + (tf-t0) + " milisegundos");
		
		t0 = System.currentTimeMillis();	 
		recorreIterador(ll);
		tf = System.currentTimeMillis();	 
		System.out.println("LinkedList con Iterator " + (tf-t0) + " milisegundos");
		
		t0 = System.currentTimeMillis();	 
		recorre(al);
		tf = System.currentTimeMillis();	 
		System.out.println("ArrayList " + (tf-t0) + " milisegundos");
		
		t0 = System.currentTimeMillis();	 
		recorre(ll);
		tf = System.currentTimeMillis();	 
		System.out.println("LinkedList " + (tf-t0) + " milisegundos");
	}
	
	public static void cargaLista(List<String> lista, int cant) {
		for (int i = 1; i <= cant; i++) {
			lista.add("a");
		}
	}
	
	public static void recorre(List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			String elemento = lista.get(i);
		}
	}
	
	public static void recorreIterador(List<String> lista) {
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			String elemento = it.next();
		}
	}
}
