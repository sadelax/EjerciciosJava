package colecciones.genericos.listas;

import java.util.Iterator;

public interface Lista <E> extends Iterable<E> {
	
	void agregar(E dato);
		
	E eliminar(int pos);
		
	E buscar(int pos);
	
	boolean estaVacia();
	
	int tamanyo();

	Iterator<E> iterator();
}
