package es.cursogetafe.banco.persistencia.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.cursogetafe.banco.modelo.Cliente;
import es.cursogetafe.banco.persistencia.ClienteDao;

@Component
public class TestClienteDao {

	@Autowired
	ClienteDao cd;
	
	@PostConstruct
	public void test() {
		Cliente c = cd.findById(4);
		System.out.println(c);
	}
}
