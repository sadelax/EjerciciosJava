package es.getafe.examen.vista.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionsFactory {
	
	private Map<String, Action> actions;
	
	public final String VISTA_PRE = "/WEB-INF/vistas/";
	public final String VISTA_POST = ".jsp";
	
	public ActionsFactory() {
		creaActions();
	}
	
	public Action getAction(HttpServletRequest req) {
		String clave = req.getMethod() + req.getPathInfo();
					//   GET o POST      /menu_principal
		String clave2 = "GET-POST" + req.getPathInfo();
		
		Action respuesta;
		
		if(actions.containsKey(clave))
			respuesta = actions.get(clave);
		else if(actions.containsKey(clave2))
			respuesta = actions.get(clave2);
		else
			respuesta = actions.get("URL_INCORRECTA");
		return respuesta; 
	}
	
	private void creaActions() {
		actions = new HashMap<>();
		actions.put("GET-POST/login", new LoginAction());
		actions.put("GET/menu_principal", new MenuPrincipalAction());
		actions.put("GET-POST/listado_productos", new ListadoProductosAction());
		actions.put("URL_INCORRECTA", new CerrarSesionAction());
		actions.put("GET/cerrar_sesion", actions.get("URL_INCORRECTA"));
	}
	
}
