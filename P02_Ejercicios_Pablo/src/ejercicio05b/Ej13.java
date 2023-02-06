package ejercicio05b;

//Método que reciba una cadena y comprueba si el balanceo de paréntesis es correcto 
//  (se abren y se cierran correctamente).
public class Ej13 {

	public static void main(String[] args) {
		System.out.println(balanceoCorrecto(")(((asdf)asdf(asdf)asdf)"));
		System.out.println(balanceoCorrecto("((asdf)asdf(asdfasdf)"));

		System.out.println(esBalanceoCorrecto(")(((asdf)asdf(asdf)asdf)"));
		System.out.println(esBalanceoCorrecto("((asdf)asdf(asdfasdf)"));
		
		System.out.println(esBalanceoCorrecto(")("));
	}
	
	public static boolean balanceoCorrecto(String str) {
		int abre = 0;
		int cierra = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') abre++;
			else if(c == ')') cierra++;
		}
		return abre == cierra;
	}

	public static boolean esBalanceoCorrecto(String str) {
		boolean correcto = true;
		int cantAbiertos = 0;
		for (int i = 0; i < str.length() && correcto; i++) {
			char c = str.charAt(i);
			if (c == '(') cantAbiertos++;
			else if (c == ')')
				if (cantAbiertos > 0)
					cantAbiertos--;
				else
					correcto = false;
		}
		return correcto && cantAbiertos == 0;
	}
}
