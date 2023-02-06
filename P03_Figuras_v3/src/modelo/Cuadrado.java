package modelo;

import modelo.interfaces.Pintable;

public class Cuadrado extends Rectangulo implements Pintable {
	
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

	@Override
	public void pintar() {
		System.out.println("estoy pintando un cuadrado.");
		
	}
}
