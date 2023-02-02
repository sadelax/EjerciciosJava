package modelo;

public class Rectangulo extends Figura{
	public double l1;
	public double l2;
	
	public Rectangulo(double x, double y, double l1, double l2) {
		super(x, y);
		this.l1 = l1;
		this.l2 = l2;
	}
	
	public String toString() {
		return "Rect[" + x + ", " + y + "; " + l1 + ", " + l2 + "]";
	}
	
	public double area() {
		return l1 * l2;
	}
}
