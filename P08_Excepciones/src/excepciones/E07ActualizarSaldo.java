package excepciones;

public class E07ActualizarSaldo {
	
	public static void main(String[] args) {
		try {
			ActualizarSaldo(-3);
			System.out.println("saldo añadido");
		} catch (SaldoInsuficienteException e) {
			System.out.println("no has añadido nada");
		} finally {
			System.out.println("fin del comunicado");
		}
	}
	
	public static void ActualizarSaldo(int saldo) throws SaldoInsuficienteException {
		if (saldo < 0)
			throw new SaldoInsuficienteException();
	}

}