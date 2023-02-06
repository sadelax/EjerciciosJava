package vasos;

import util.Util;

public class PilaVasos2 {
	public static void main(String[] args) {
		int cant;
		
		cant = Util.leerInt("Cantidad de vasos");
		
		for (int i = 1; i <= cant; i++) {
			for (int j = 1; j <= cant - i; j++) {
				Util.mostrarSinSalto(" ");
			}
			for (int j = 1; j <= i; j++) {
				Util.mostrarSinSalto("* ");
			}
			Util.mostrar("");
		}
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= cant-1; j++) {
				Util.mostrarSinSalto(" ");
			}
			Util.mostrar("*");
		}
		
	}
}
