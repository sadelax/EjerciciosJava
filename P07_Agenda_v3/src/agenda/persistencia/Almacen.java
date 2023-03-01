package agenda.persistencia;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import agenda.modelo.Contacto;

@SuppressWarnings("serial")
class Almacen implements Serializable {
	
	Map<Integer, Contacto> mapa;
	int autoIncrement;
	
	Almacen(){
		mapa = new HashMap<>();
		autoIncrement = 1;
	}
}
