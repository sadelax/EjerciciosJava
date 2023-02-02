package modelo;

public class Figura {
	
	public double x;
	public double y;
	
	public Figura() {}
	
	public Figura(double x, double y) {
//		super(); // esto llamaría al constructor de Object. Ese es el constructor por defecto.
		this.x = x;
		this.y = y;
	}
	
	public double area() {
		return 0;
	}
}
