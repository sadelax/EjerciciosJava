package sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import agenda.modelo.Contacto;

public class Test02Tree {
	public static void main(String[] args) {
		Set<String> ts = new TreeSet<>();
		ts.add("lunes");
		ts.add("martes");
		ts.add("miercoles");
		ts.add("jueves");
		ts.add("viernes");
		
		for(String dia : ts) {
			System.out.println(dia);
		}

		System.out.println();
		
		Set<Integer> tsInt = new TreeSet<>();
		tsInt.add(97);
		tsInt.add(2);
		tsInt.add(599);
		tsInt.add(8);
		tsInt.add(12);
		tsInt.add(55);
		for (Integer num : tsInt) {
			System.out.println(num);
		}
		
		System.out.println();
		

		Set<Contacto> contactos = new TreeSet<>();
		
		Contacto c1 = new Contacto();
		c1.setIdContacto(1);
		c1.setNombre("Federico");
		
		
		Contacto c2 = new Contacto();
		c2.setIdContacto(2);
		c2.setNombre("juan");
		
		Contacto c3 = new Contacto();
		c3.setIdContacto(3);
		c3.setNombre("Adrian");
		
		Contacto c4 = new Contacto();
		c4.setIdContacto(4);
		c4.setNombre("ádrian");		
		
		Contacto c5 = new Contacto();
		c5.setIdContacto(5);
		c5.setNombre("rodrigo");
		
		contactos.add(c1);
		contactos.add(c2);
		contactos.add(c3);
		contactos.add(c4);
		contactos.add(c5);
		
		for (Contacto contacto : contactos) {
			System.out.println(contacto);
		}
	}
}
