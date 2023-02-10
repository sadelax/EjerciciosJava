package colecciones.genericos.listas;

import java.util.Iterator;

public class ListaEnlazada<E> implements Lista<E> {
	
	private Nodo primero;
	private Nodo ultimo;
	private int cantidad;

	@Override
	public void agregar(E dato) {
		Nodo nuevo = new Nodo(dato);
		if(primero == null) {
			primero = nuevo;
		} else {
			ultimo.proximo = nuevo;
		}
		ultimo = nuevo;
		cantidad++;
	}

	@Override
	public E eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E buscar(int pos) {
		if(pos < cantidad && pos >= 0) {
			Nodo aux = primero;
			for (int i = 1; i < pos; i++) {
				aux = aux.proximo;
			}
			return aux.dato;
		} else
			return null;
	}

	@Override
	public boolean estaVacia() {
		return cantidad == 0;
	}

	@Override
	public int tamanyo() {
		return cantidad;
	}
	
	private class Nodo {
		E dato;
		Nodo proximo;
		
		public Nodo(E dato) {
			this.dato = dato;
		}
		
		public Nodo(E dato, Nodo proximo) {
			this(dato); // esto es lo mismo que this.dato = dato;
			this.proximo = proximo;
		}
	}

	@Override
	public Iterator<E> iterador() {
		// TODO Auto-generated method stub
		return null;
	}
}
