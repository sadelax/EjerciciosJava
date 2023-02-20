package sets;

import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;

public class Test05Lambdas {
	public static void main(String[] args) {
		Contacto c1 = new Contacto(50, "Amancio", "Poca Pasta");
		Contacto c2 = new Contacto(10, "Pedro", "Zeta");
		Contacto c3 = new Contacto(55, "Mario", "Zeta");
	
		Set<Contacto> s1 = new TreeSet<>((o1, o2)->o1.getIdContacto()-o2.getIdContacto());
		s1.add(c1);
		s1.add(c2);
		s1.add(c3);
		s1.forEach(System.out::println);
	}
}
