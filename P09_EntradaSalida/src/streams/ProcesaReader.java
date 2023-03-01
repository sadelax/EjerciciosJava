package streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class ProcesaReader {

	public static void main(String[] args) throws IOException, RuntimeException {
		
//		visualiza(System.in);
//		visualiza(new FileReader("/curso/figura.txt"));
		URL direccion = new URL("https://www.elmundo.es/index.html");
		visualiza(direccion.openStream());
	}
	
	
	public static void visualiza(Reader r) throws RuntimeException {
		try(BufferedReader br = new BufferedReader(r)){
			String linea;
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
		} catch(IOException e) {
			throw new RuntimeException("error");
		}
	}
	
	public static void visualiza(InputStream is) {
		visualiza(new InputStreamReader(is));
	}
}
