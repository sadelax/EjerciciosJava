package banco;

public class Persona implements Runnable {
	private String nombre;
	private CuentaCorriente cuenta;
	
	private int operacion = 0;
	private final byte INGRESO = 0;
	private final byte REINTEGRO = 1;

	public Persona(String nom, CuentaCorriente cc) {
		nombre = nom;
		cuenta = cc;
	}

	public int getSaldo() {
		return cuenta.getSaldo();
	}

	public void run() {
		while (true) {
			int cantidad = (int) Math.round(Math.random() * 1000);
			double ingReint = Math.random();
			if (ingReint < 0.5)
				operacion = REINTEGRO;
			else
				operacion = INGRESO;

			System.out.print(this.nombre + " realizar� un "
					+ (operacion == INGRESO ? "ingreso" : "reintegro"));
			System.out.println(" de " + cantidad + " Euros");

			if (operacion == REINTEGRO)
				if (cuenta.sacarDinero(cantidad)) {
					System.out.print(this.nombre + " realiz� un "
							+ (operacion == INGRESO ? "ingreso" : "reintegro"));
					System.out.println(" de " + cantidad + " Euros");
				} else
					cuenta.ingresarDinero(cantidad);

			if (cuenta.getSaldo() < 0) {
				System.out.println("La libreta tiene un saldo negativo: "
						+ cuenta.getSaldo());
				System.exit(0);
			}
		}
	}

	public static void main(String[] arg) {
		CuentaCorriente libreta = new CuentaCorriente(100);
		Persona padre = new Persona("PEPE", libreta);
		Persona madre = new Persona("***********MARIA", libreta);

		new Thread(padre).start();
		new Thread(madre).start();
	}
}
