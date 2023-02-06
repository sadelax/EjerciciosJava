package vasos;

import util.Util;

public class PilaVasos {
	public static void main(String[] args) {
		int cant, x, y;
		
		cant = Util.leerInt("Cantidad de vasos");
		
		for (int i = 1; i <= cant; i++) {
			x = i;
			y = i;
			for (int j = i; j <= cant; j++) {
				Util.mostrar(x + "-" + y);
				y = y + 2;
			}
			Util.mostrar("----------------");
		}
	}
}
