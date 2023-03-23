package es.cursogetafe.banco.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cursogetafe.banco.persistencia.BancoDaoInterface;

@Service
public class BancoNegocio implements BancoNegocioInterface {
	
	@Autowired
	private BancoDaoInterface bancoDao;

	public BancoNegocio() {
	}

	public void transferencia(long dni1, long dni2, double cantidad) {
		System.out.println("Inicio de la transferencia");
		bancoDao.cambiarSaldo(dni1, cantidad);
		bancoDao.cambiarSaldo(dni2, -cantidad);
		System.out.println("Transferencia realizada");
	}

	// ------------ Getters y setters------------
	public BancoDaoInterface getBancoDao() {
		return bancoDao;
	}

	public void setBancoDao(BancoDaoInterface bancoDao) {
		this.bancoDao = bancoDao;
	}

}
