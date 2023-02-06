package tests;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Rectangulo;
import modelo.Rombo;

public class Test01 {
	public static void main(String[] args) {
		Rectangulo r = new Rectangulo(1.5, -16.9, 8, 7);
		System.out.println(r.getX());
		System.out.println(r.getY());
		System.out.println(r.getL1());
		System.out.println(r.getL2());
		System.out.print("área del rectángulo: ");
		System.out.println(r.area());
		System.out.print("perímetro del rectángulo: ");
		System.out.println(r.perimetro());
		System.out.println(r);
		
		r.setX(0);
		r.setY(0);
		
		System.out.println(r);

		Circulo c = new Circulo(4, 2, 5);
		
		System.out.println(c.getX());
		System.out.println(c.getY());
		System.out.println(c.getR());
		System.out.print("área del círculo: ");
		System.out.println(c.area());
		System.out.print("perímetro del círculo: ");
		System.out.println(c.perimetro());
		System.out.println(c);
		
		Rombo rom = new Rombo(1, 2, 3, 4);
		System.out.print("área del rombo: ");
		System.out.println(rom.area());
		System.out.print("perímetro del rombo: ");
		System.out.println(rom.perimetro());
		System.out.println(rom);
		
		Cuadrado cuad = new Cuadrado(1, 2, 4);
		System.out.print("área del cuadrado: ");
		System.out.println(cuad.area());
		System.out.print("perímetro del cuadrado: ");
		System.out.println(cuad.perimetro());
		System.out.println(cuad);
		
	}
}
