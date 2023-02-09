package colecciones.listas;

public class ListaArray implements Lista {
	
	private String[] almacen;
	private int cantidad;
	
	public ListaArray() {
		almacen = new String[10];
		cantidad = 0;
	}
	
	public ListaArray(int tam) {
		almacen = new String[tam];
		cantidad = 0;
	}
	
	@Override
	public void agregar(String dato) {
		if(almacen.length == cantidad) {
			redimensionar();
		}
		almacen[cantidad] = dato;
		cantidad++;
	}

	@Override
	public String eliminar(int pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscar(int pos) {
		return almacen[pos];
	}

	@Override
	public boolean estaVacia() {
		return cantidad == 0;
	}

	@Override
	public int tamanyo() {
		return cantidad;
	}
	
	private void redimensionar() {
		String[] nuevo = new String[almacen.length * 2];
		for(int i = 0; i < almacen.length; i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}
}
