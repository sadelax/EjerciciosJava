package banco;

public class CuentaCorriente {
	private int saldo;

	public CuentaCorriente(int saldoInicial) {
		saldo = saldoInicial;
	}

	public synchronized boolean sacarDinero(int importe) {
		if (importe < saldo) {
			System.out.println("Saldo anterior: " + saldo);
			saldo -= importe;
			System.out.println("Saldo actual: " + saldo);
			return true;
		} else
			return false;
	}

	public void ingresarDinero(int importe) {
		System.out.println("Saldo anterior: " + saldo);
		saldo += importe;
		System.out.println("Saldo actual: " + saldo);
	}

	public int getSaldo() {
		return saldo;
	}
}
