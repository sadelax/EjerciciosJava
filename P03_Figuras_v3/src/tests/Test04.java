package tests;

import modelo.Cuadrado;
import modelo.Rombo;
import modelo.interfaces.Pintable;
import pruebas.Cliente;

public class Test04 {
	public static void main(String[] args) {
		pintaAlgo(new Rombo(1, 2, 3, 4));
		pintaAlgo(new Cliente());
		pintaAlgo(new Cuadrado(5, 3, 5));
	}
	public static void pintaAlgo(Pintable p) {
		p.pintar();
	}
}
