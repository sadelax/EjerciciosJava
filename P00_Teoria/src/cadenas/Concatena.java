package cadenas;

public class Concatena {
	public static void main(String[] args) {
		String s = "";
		StringBuilder sb = new StringBuilder("");
		StringBuffer sbf = new StringBuffer("");
		long t0, tf;
		
		// tiempo en memoria estática
		t0 = System.currentTimeMillis();
		for(int i = 1; i <= 100000; i++) {
			s+= "a";
		}
		tf = System.currentTimeMillis();
		System.out.println("String: " + (tf - t0));
		
		// tiempo en memoria dinámica
		t0 = System.currentTimeMillis();
		for(int i = 1; i <= 10000000; i++) {
			sb.append("a");
		}
		tf = System.currentTimeMillis();
		System.out.println("Stringbuilder: " + (tf - t0));
		
		// tiempo en memoria buffer
		t0 = System.currentTimeMillis();
		for(int i = 1; i <= 10000000; i++) {
			sbf.append("a");
		}
		tf = System.currentTimeMillis();
		System.out.println("Stringbuffer: " + (tf - t0));
	}
}
