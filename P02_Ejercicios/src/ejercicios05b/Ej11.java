package ejercicios05b;
// Pedir una frase y eliminar las vocales. No se puede usar replace ni replaceAll.
public class Ej11 {
	public static void main(String[] args) {
		System.out.println(sinVocales("pantocrator"));					// pntcrtr
		System.out.println(sinVocales("ministerio de las basicas"));	// mnstr d ls bscs
	}
	public static String sinVocales(String frase) {
		String nuevo = "";
		int i = 0;
		while(i < frase.length()) {
			if(frase.charAt(i) != 'a') {
				if(frase.charAt(i) != 'e') {
					if(frase.charAt(i) != 'i') {
						if(frase.charAt(i) != 'o') {
							if(frase.charAt(i) != 'u') {
								nuevo += frase.charAt(i);
							}
						}
					}
				}
			}
			i++;
		}

		return nuevo;
	}
}
