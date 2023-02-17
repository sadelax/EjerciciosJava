package sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import agenda.modelo.Contacto;

public class Test01Hash {
	
	public static void main(String[] args) {
		
	// Hashset - muestra los resultados desordenados
		HashSet<String> hs = new HashSet<>();
		hs.add("lunes");
		hs.add("martes");
		hs.add("miercoles");
		hs.add("jueves");
		hs.add("viernes");
		
		for(String dia : hs) {
			System.out.println(dia);
		}
		
		System.out.println();
		
		// LinkedHashSet - muestra los resultados tal y como los ingresé
		Set<String> lhs = new LinkedHashSet<>();
		lhs.add("lunes");
		lhs.add("martes");
		lhs.add("miercoles");
		lhs.add("jueves");
		lhs.add("viernes");
		
		for(String dia : lhs) {
			System.out.println(dia);
		}
		
		System.out.println();

		List<String> lista = new ArrayList<>(hs);
		
		for(String dia : lhs) {
			System.out.println(dia);
		}
		
		System.out.println();
		
		Set<Contacto> contactos = new HashSet<>();
		
		Contacto c1 = new Contacto();
		c1.setIdContacto(15);
		c1.setNombre("Federico");
		
		
		Contacto c2 = new Contacto();
		c2.setIdContacto(8);
		c2.setNombre("Juan");
		
		Contacto c3 = new Contacto();
		c3.setIdContacto(4);
		c3.setNombre("Adrian");
		
		Contacto c4 = new Contacto();
		c4.setIdContacto(15);
		c4.setNombre("Juan Carlos");
		
		contactos.add(c1);
		contactos.add(c2);
		contactos.add(c3);
		contactos.add(c4);
		
		for (Contacto contacto : contactos) {
			System.out.println(contacto);
		}
	}
}
