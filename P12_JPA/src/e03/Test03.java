package e03;

import javax.persistence.EntityManager;

import e02.Genero;
import util.EMF;

public class Test03 {
	public static void main(String[] args) {
		// equivalente al datasource
		EntityManager em = EMF.getEmf().createEntityManager();
				
		Persona03 p = em.find(Persona03.class, 7);		// busca en la tabla persona02 la primary key valor 7 (en este caso id 7)
		if(p != null) {
			System.out.println(p.getApellidos() + " " + p.getNombre());
			System.out.println(p.getDomicilio().getTipoVia() + " " + p.getDomicilio().getVia());
			System.out.println(p.getGenero());
		}
		
		Persona03 nuevo = new Persona03();
		nuevo.setApellidos("montero");
		nuevo.setApodo("Paco");
		nuevo.setDni("sin_papeles");
		nuevo.setNombre("dani");
		nuevo.setGenero(Genero.MASCULINO);
		
		Domicilio d = new Domicilio();
		
		d.setCiudad("Madrid");
		d.setCodigoPostal("28009");
		d.setNumero(75);
		d.setPiso(17);
		d.setProvincia("Madrid");
		d.setPuerta("A");
		d.setTipoVia("Avenida");
		d.setVia("guadalajara");
		
		nuevo.setDomicilio(d);
		
		// iniciar transaccion para commitear o rollbackear
		em.getTransaction().begin();
		// para "insertar" una nueva tabla en la base de datos
		em.persist(nuevo);
		// devuelve la transacción en curso, en este caso, begin
		em.getTransaction().commit();
		
//		 importante cerrar para que, si hay fallos, no se quede ejecutando
		em.close();
		EMF.getEmf().close();
	}
}
