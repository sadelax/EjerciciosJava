package cadenas;

public class PruebaEquals {
	public static void main(String[] args) {
		String s1 = "hola";
		String s2 = "hola";
		System.out.println(s1 == s2);

		String s3 = "HOLA".toLowerCase();
		
		System.out.println(s1 == s3);
		
		String s4 = new String("hola").intern();
		System.out.println(s1 == s4);
		
	}
}	
