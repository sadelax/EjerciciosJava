package modelo;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(double x, double y, double lado) {
		super(x, y, lado, lado);
	}
	
	public String toString() {
		return "Cuadrado[" + x + ", " + y + "; " + l1 + "]";
	}
}
