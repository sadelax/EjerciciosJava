package repaso;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet01 {

	public static void main(String[] args) {
		
		Set<Persona> personas;
//		personas = new HashSet<>();
//		personas = new LinkedHashSet<>();
//		personas = new TreeSet<>();
		personas = new TreeSet<>(Persona.compNombre());
		
		personas.add(new Persona(75, "AA"));
		personas.add(new Persona(76, "Aj"));
		personas.add(new Persona(756, "Ah"));
		personas.add(new Persona(751, "Ag"));
		personas.add(new Persona(759, "Af"));
		personas.add(new Persona(754, "Ab"));
		
		// PARA QUÉ ES BUENO EL HASH? Para hacer búsquedas. PERO modifica el orden de carga debido a la tabla de dispersión.
		// PARA QUÉ ES BUENO EL LINKEDHASHSET? Para hacer búsquedas, respetando el orden de carga. PERO es algo más lento.
		// PARA QUÉ ES BUENO EL TREESET? Para ordenar la carga de manera natural o definida por el usuario.
			// IMPRESCINDIBLE que Persona implemente la interfaz COMPARABLE para ordenar la carga de manera natural.
			// IMPRESCINDIBLE que Persona se compare con otra Persona en un objeto comparator para ordenar la carga definida por el usuario.
			// CHECK iterator e iterable para saber de qué manera se itera sobre una colección.
		
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}
	
	
}
