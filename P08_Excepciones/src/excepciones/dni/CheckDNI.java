package excepciones.dni;

public class CheckDNI {

	// Formato dni DDDDDDDD-L
	// Formato nie L-DDDDDDD-L
	public static String formateaDni(String dni) throws FailDNIException {
		boolean correcto = false;
		String nuevo;
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		boolean nie = true;
		char letra = ' ', letraNie = ' ';
		
		dni = dni.replaceAll(" ", "").replaceAll("-", "").toUpperCase();
		
		if (dni.length() <= 8) {
			String dniCp = dni;
			for (int i = 0; i < 9 - dniCp.length(); i++) {
				dni = "0" + dni;
			}
		}
		if (dni.length() == 9) {
			// checkear si es un nie
			letraNie = dni.charAt(0);
			switch (letraNie) {
			case 'X':
				dni = "0" + dni.substring(1);
				break;
			case 'Y':
				dni = "1" + dni.substring(1);
				break;
			case 'Z':
				dni = "2" + dni.substring(1);
				break;
			default:
				nie = false;
			}
			try {
				int nro = Integer.parseInt(dni.substring(0, dni.length() - 1));
				letra = dni.charAt(dni.length() - 1);
				correcto = letras.charAt(nro % 23) == letra;
			} catch (NumberFormatException e) {
				// no cambiamos el valor de correcto. Vale false
			}
		}
		if (correcto) {
			if (nie) {
				nuevo = letraNie + "-" + dni.substring(1, 8) + "-" + letra;
			} else {
				nuevo = dni.substring(0, 8) + "-" + letra;
			}
			return nuevo;
		} else {
			throw new FailDNIException("El dni/nie " + dni + " es incorrecto");
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(formateaDni("1R"));
			System.out.println(formateaDni("50770005N"));
			System.out.println(formateaDni("50770005j"));
		} catch (FailDNIException e) {
			System.out.println(e.getMessage());
		}
	}

}
