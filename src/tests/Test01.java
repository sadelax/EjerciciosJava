package tests;

import modelo.Circulo;
import modelo.Rectangulo;

public class Test01 {
	public static void main(String[] args) {
		Rectangulo r = new Rectangulo(1.5, -16.9, 8, 7);
		System.out.println(r.x);
		System.out.println(r.y);
		System.out.println(r.l1);
		System.out.println(r.l2);
		System.out.println(r.area());
		System.out.println(r);
		
		Circulo c = new Circulo(4, 2, 5);
		System.out.println(c.x);
		System.out.println(c.y);
		System.out.println(c.r);
		System.out.println(c.area());
		System.out.println(c);
	}
}
