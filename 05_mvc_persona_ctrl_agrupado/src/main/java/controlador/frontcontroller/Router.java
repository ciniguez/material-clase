package controlador.frontcontroller;

import java.util.HashMap;

public class Router {

	private static Router router = null;
	
	private HashMap<String, Object> rutas;
	
	private Router() {
		rutas = new HashMap<String, Object>();
		System.out.println("Constructor de Router - Singleton");
	}
	
	public static Router getInstance() {
		if(router == null) {
			router = new Router();
		}
		return router;
	}
	
	public void addRoute( String nombreRuta, Route ruta) {
		this.rutas.put(nombreRuta, ruta);
	}
	public HashMap<String, Object> getRutas(){
		return this.rutas;
	}
}
