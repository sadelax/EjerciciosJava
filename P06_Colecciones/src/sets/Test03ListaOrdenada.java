package sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import agenda.modelo.Contacto;

public class Test03ListaOrdenada {
	public static void main(String[] args) {
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
		
		List<Contacto> lista = new ArrayList<>();
		lista.add(c5);
		lista.add(c3);
		lista.add(c4);
		lista.add(c2);
		lista.add(c1);
		
		for (Contacto contacto : lista) {
			System.out.println(contacto);
		}
		
		System.out.println("-----------------------");
		
		Collections.sort(lista);
		
		for (Contacto contacto : lista) {
			System.out.println(contacto);
		}
		
		System.out.println("-----------------------");
		
		Collections.sort(lista, new ContactoIdComparator());
		
		for (Contacto contacto : lista) {
			System.out.println(contacto);
		}
		
	}
}
