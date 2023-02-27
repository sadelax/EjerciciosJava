package excepciones;

public class E07ActualizarSaldo {
	
	public static void main(String[] args) {
		int saldo = 0;
		try {
			ActualizarSaldo(100);
			System.out.println("saldo añadido");
		} catch (SaldoInsuficienteException e) {
			System.out.println("No tienes saldo lo siento");
		} finally {
			System.out.println("has añadido tu saldo");
		}
	}
	
	public static void ActualizarSaldo(int saldo) throws SaldoInsuficienteException {
		if (saldo < 0)
			throw new SaldoInsuficienteException();
	}
}