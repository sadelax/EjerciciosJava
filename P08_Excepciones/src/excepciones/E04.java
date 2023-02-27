package excepciones;

import java.io.IOException;

public class E04 {
	
	public static void main(String[] args) {
		try {
			metodoProblematico();			
			metodoProblematico();			
			metodoProblematico();			
			metodoProblematico();
			System.out.println("rara vez se ejecutará - solo si las anteriores salieron ok");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void metodoProblematico() throws IOException {
		double num = Math.random();
		if(num > 0.1) {
			System.out.println("todo funciona ok");
		} else {
			throw new IOException("tuvimos mala suerte :(");
		}
	}
}
