package excepciones;

import java.io.IOException;
import java.sql.SQLException;

public class E03 {

	public static void main(String[] args) throws IOException, SQLException {
		try {
			metodoProblematico(-55);
		} catch (IOException | SQLException e){
			// de esta manera el arreglo es el mismo para ambos...
			metodoProblematico(55);
		}
//		}catch(SQLException e){
//			...pero también se podría solucionar el arreglo por separado
//		}
//		} catch (Excepcion e) {
//			así tb valdría pero sería englobar demasiado (uso de polimorfismo)
//		}
	}

	public static void metodoProblematico(int num) throws IOException, SQLException {
		if (num > 0) {
			System.out.println("opero perfectamente");
		} else if (num == 0) {
			throw new SQLException("no puede ser 0");
		} else {
			throw new IOException("no puede ser negativo");
		}
			
	}

}
