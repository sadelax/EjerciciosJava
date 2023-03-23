package es.cursogetafe.banco.negocio;

import es.cursogetafe.banco.persistencia.BancoDao;
import es.cursogetafe.banco.persistencia.BancoDaoInterface;

public class BancoNegocio implements BancoNegocioInterface {
	private BancoDaoInterface bancoDao;

	public BancoNegocio() {
		bancoDao = new BancoDao();
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
