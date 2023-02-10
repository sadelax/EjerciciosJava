package listas;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		// ojo! uso el tipo List mejor (ArrayList), ya que al declarar mejor usar el nombre de la INTERFAZ!
		
		lista.add("enero");
		lista.add("febrero");
		lista.add("marzo");
		lista.add("abril");
		lista.add("mayoOoO");
		
		System.out.println(lista.size());
		System.out.println(lista.get(2));
		System.out.println(lista.get(4));
		
	}
}
