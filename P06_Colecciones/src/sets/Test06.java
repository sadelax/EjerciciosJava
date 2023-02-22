package sets;

import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;

public class Test06 {
	public static void main(String[] args) {
		Contacto c1 = new Contacto(50, "Amancio", "Poca Pasta");
		Contacto c2 = new Contacto(10, "Pedro", "Zeta");
		Contacto c3 = new Contacto(55, "Mario", "Alfa");
		
		Set<Contacto> ss = new TreeSet<>(Contacto.getIdComparator());
		ss.add(c1);
		ss.add(c2);
		ss.add(c3);
		
		for (Contacto contacto : ss) {
			System.out.println(contacto);
		}
	}
}
