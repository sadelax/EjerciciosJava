package repaso;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
		
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		
		// FUNCIONAMIENTO INTERNO DE UN FOREACH
		Iterator<Persona> it = personas.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
