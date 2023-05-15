package pruebajson;

import java.util.Arrays;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Contacto;
import modelo.Domicilio;

public class Prueba {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Contacto c = new Contacto();
		c.setIdContacto(123);
		c.setNombre("pedrita");
		c.setApellidos("perez jimenez");
		c.setApodo("jose martin");
		c.setCorreos(new HashSet(Arrays.asList("b@b.b", "a@a.a")));
		c.setTelefonos(new HashSet(Arrays.asList("1111111", "222222")));
		Domicilio d = new Domicilio();
		d.setCiudad("madrid");
		d.setCiudad("22222");
		d.setNumero(45);
		d.setPiso(98);
		d.setProvincia("madrid");
		d.setPuerta("A");
		d.setTipoVia("via");
		d.setVia("lactea");
		c.setDom(d);
		
		System.out.println(c);
		
		Gson gson = new Gson();
		
		String contactoJson = gson.toJson(c);
		System.out.println(contactoJson);
		
		Contacto nuevo = gson.fromJson(contactoJson, Contacto.class);
		System.out.println(nuevo);
		
		Gson gsonExpose = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String contactoJsonSimple = gsonExpose.toJson(c);
		System.out.println(contactoJsonSimple);
		
	}
}
