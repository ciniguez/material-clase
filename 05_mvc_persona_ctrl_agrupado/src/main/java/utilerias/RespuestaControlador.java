package utilerias;

import java.util.HashMap;

public class RespuestaControlador {
	private String paginaDestino;
	private HashMap<String, Object> datos;
	private boolean isRedirect = false;

	
	public RespuestaControlador(String paginaDestino, HashMap<String, Object> datos, boolean isRedirect) {
		super();
		this.paginaDestino = paginaDestino;
		this.datos = datos;
		this.isRedirect = isRedirect;
	}
	
	public RespuestaControlador() {
	}

	public String getPaginaDestino() {
		return paginaDestino;
	}
	public void setPaginaDestino(String paginaDestino) {
		this.paginaDestino = paginaDestino;
	}
	public HashMap<String, Object> getDatos() {
		return datos;
	}
	public void setDatos(HashMap<String, Object> datos) {
		this.datos = datos;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	
	}
	

}
