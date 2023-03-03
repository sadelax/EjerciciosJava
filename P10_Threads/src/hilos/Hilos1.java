package hilos;

public class Hilos1 {
	
	private String mensaje;
	
	public Hilos1(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void run() {
		while(true) {
			System.out.println(mensaje);
		}
	}
	
	public static void main(String[] args) {
		Hilos1 h1 = new Hilos1("Soy el hilo 111111111111111111111");
		h1.run();
		Hilos1 h2 = new Hilos1("Soy el hilo 222222222222222222222");
		h2.run();
		Hilos1 h3 = new Hilos1("Soy el hilo 333333333333333333333");
		h3.run();
	}
}
