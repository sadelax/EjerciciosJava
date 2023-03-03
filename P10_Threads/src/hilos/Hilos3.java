package hilos;

public class Hilos3 implements Runnable{
	
	private String mensaje;
	
	public Hilos3(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public void run() {
		while(true) {
			System.out.println(mensaje);
		}
	}
	
	public static void main(String[] args) {
		Hilos3 h1 = new Hilos3("_x_____________");
		Thread t1 = new Thread(h1);
		t1.start();
		Hilos3 h2 = new Hilos3("_______x_______");
		Thread t2 = new Thread(h2);
		t2.start();
		Hilos3 h3 = new Hilos3("_____________x_");
		Thread t3 = new Thread(h3);
		t3.start();
	}

}
