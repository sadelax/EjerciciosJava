package tests;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Rectangulo;
import modelo.Rombo;

public class Test01 {
	public static void main(String[] args) {
		Rectangulo r = new Rectangulo(1.5, -16.9, 8, 7);
		System.out.println(r.x);
		System.out.println(r.y);
		System.out.println(r.l1);
		System.out.println(r.l2);
		System.out.print("área del rectángulo: ");
		System.out.println(r.area());
		System.out.print("perímetro del rectángulo: ");
		System.out.println(r.perimetro());
		System.out.println(r);
		
		Circulo c = new Circulo(4, 2, 5);
		System.out.println(c.x);
		System.out.println(c.y);
		System.out.println(c.r);
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
