package modelo;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(double x, double y, double lado) {
		super(x, y, lado, lado);
	}
	
	public String toString() {
		return "Cuadrado[" + getX() + ", " + getY() + "; " + getL1() + "]";
	}
	
	public double getLado() {
		return getL1();
	}
	
	public void setLado(double lado) {
		setL1(lado);
		setL2(lado);
	}
}
