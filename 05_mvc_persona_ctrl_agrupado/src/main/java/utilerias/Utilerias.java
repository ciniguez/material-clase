package utilerias;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Utilerias {
	public Utilerias () {}
	
	public void llamarVista(RespuestaControlador respuesta, HttpServletRequest request, HttpServletResponse response) {
		
		if(respuesta.isRedirect()) {
			try {
				response.sendRedirect(respuesta.getPaginaDestino());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			
			try {
				if(respuesta.getDatos()!= null) {
					// Configurar atributo en el request, por cada dato enviado por el controlador.
					for(Entry<String, Object> dato : respuesta.getDatos().entrySet() ) {						
						request.setAttribute(dato.getKey(), dato.getValue());
					}
				}
				request.getRequestDispatcher(respuesta.getPaginaDestino()).forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * Verifica si existe una sesion activa
	 */
	public boolean existeSesionActiva(HttpServletRequest request) {
		HttpSession sesion = request.getSession();

		Enumeration<String> nombres = sesion.getAttributeNames();
		while (nombres.hasMoreElements()) {
			System.out.println(nombres.nextElement());
		}

		// Si no existe la sesion "usuarioLogeado" entonces redirecciono a Login
		if (sesion.getAttribute("usuarioLogeado") == null) {
			return false;
		}else
			return true;

	}
}
