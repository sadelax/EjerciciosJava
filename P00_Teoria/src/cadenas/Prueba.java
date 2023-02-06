package cadenas;

public class Prueba {
	public static void main(String[] args) {
		
		String s = "Hola";
		String s1 = new String("Hola");
		
		System.out.println(s.equals(s1));
		
		System.out.println(s == s1);
		
		String s2 = "Hola";
		System.out.println(s == s2);
		
		s2 = "Adios";
		System.out.println(s);
		
		String s3 = s;
		s = s.toUpperCase();
		System.out.println(s3);
		
	}
}
