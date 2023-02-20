package sets;

import java.util.Comparator;
import agenda.modelo.Contacto;

public class ContactoIdComparator implements Comparator<Contacto>{

	@Override
	public int compare(Contacto o1, Contacto o2) {
		return o1.getIdContacto()-o2.getIdContacto();
	}
	
}
