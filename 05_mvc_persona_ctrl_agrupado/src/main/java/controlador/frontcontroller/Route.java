package controlador.frontcontroller;

/**
 * Ruta de Navegación.
 */
public class Route {

	// Nombre de la ruta
	private String nombreRuta;	
	
	// Nombre del metodo de la clase Routes que se ejecutará al recibir la ruta de navegación
	private String metodo;

	// VERDADERO si se valida que exista una sesión activa antes de ejecutar la ruta. 
	//FALSO en caso contrario.
	private boolean validarAutorizacion;
	
	public Route() {
		
	}

	public Route(String nombreRuta, String metodo, boolean validarAutorizacion) {
		this.nombreRuta = nombreRuta;
		this.metodo = metodo;
		this.validarAutorizacion = validarAutorizacion;
	}

	public String getNombreRuta() {
		return nombreRuta;
	}

	public void setNombreRuta(String ruta) {
		this.nombreRuta = ruta;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public boolean isValidarAutorizacion() {
		return validarAutorizacion;
	}

	public void setValidarAutorizacion(boolean validarAutorizacion) {
		this.validarAutorizacion = validarAutorizacion;
	}
	
	
}
