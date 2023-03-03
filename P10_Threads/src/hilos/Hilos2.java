package hilos;

public class Hilos2 extends Thread{
	
	private String mensaje;
	
	public Hilos2(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void run() {
		while(true) {
			System.out.println(mensaje);
		}
	}
	
	public static void main(String[] args) {
		Hilos2 h1 = new Hilos2("_x_____________");
		h1.start();
		Hilos2 h2 = new Hilos2("_______x_______");
		h2.start();
		Hilos2 h3 = new Hilos2("_____________x_");
		h3.start();
	}
}
