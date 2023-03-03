package agenda.inicio;

import agenda.config.Config;
import agenda.vista.MenuPrincipal;
import agenda.vista.swing.VInicial;

public class Main {
	public static void main(String[] args) {
		String tipoVista = Config.getProperty("vista");
		switch (tipoVista) {
		case "consola":
			new MenuPrincipal().menu();
			break;
		case "grafico":
			new VInicial();
			break;
		default:
			new VInicial();
			break;
		}
	}
}
