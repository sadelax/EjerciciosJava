package repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestList01Sort {

	public static void main(String[] args) {
		
		List<Persona> personas;
		
//		personas = new ArrayList<>();
		personas = new LinkedList<>();
		
		personas.add(new Persona(75, "AA"));
		personas.add(new Persona(76, "Aj"));
		personas.add(new Persona(756, "Ah"));
		personas.add(new Persona(751, "Ag"));
		personas.add(new Persona(759, "Af"));
		personas.add(new Persona(754, "Ab"));
		
		// PARA QUÉ ES BUENO EL ARRAYLIST? Para hacer búsquedas por posición.
		// PARA QUÉ ES BUENO EL LINKEDLIST? Para inserción y eliminación eficiente en el medio de la lista.
		// Y CÓMO LOS ORDENAMOS? Con Collection.sort.
			// OJO! IMPRESCINDIBLE que la clase implemente COMPARABLE
			// necesito elementos repetidos? usa list, por favor.
			// necesito que los elementos no se repitan? usa treeset.
		
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		Collections.sort(personas);
		Collections.sort(personas, new Comparator<Persona>() {

			@Override
			public int compare(Persona p1, Persona p2) {
				return p1.getNombre().compareTo(p2.getNombre()); // ojo 
			}
			
		});
	}
	
}
