package colecciones.genericos.listas;

public interface Lista <E> {
	
	void agregar(E dato);
		
	E eliminar(int pos);
		
	E buscar(int pos);
	
	boolean estaVacia();
	
	int tamanyo();
}
