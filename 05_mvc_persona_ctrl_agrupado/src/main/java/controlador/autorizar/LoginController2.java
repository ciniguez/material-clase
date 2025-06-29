package controlador.autorizar;


import java.util.HashMap;
import jakarta.servlet.http.HttpSession;
import modelo.Persona;
import utilerias.RespuestaControlador;

public class LoginController2 {
	RespuestaControlador respuesta = null;
	
	public LoginController2() {
		respuesta = new RespuestaControlador();
	}

	public RespuestaControlador inicio(){
		RespuestaControlador respuesta = new RespuestaControlador();
		respuesta.setDatos(null);
		respuesta.setPaginaDestino("jsp/login.jsp");
		respuesta.setRedirect(true);
		return respuesta;
		//response.sendRedirect("jsp/login.jsp");	
	}
	public RespuestaControlador ingresar(String usuario, String password, HttpSession sesion){
		

		Persona persona = new Persona();
		Persona personaAutorizada = persona.autorizar(usuario, password);


		if (personaAutorizada != null) {
			sesion.setAttribute("usuarioLogeado", personaAutorizada);
			respuesta.setPaginaDestino("FrontController?ruta=listar");
			respuesta.setRedirect(true);
			//response.sendRedirect("GestionarPersonaController?ruta=listar");
		} else {
			HashMap<String, Object> datos = new HashMap<String, Object>();
			datos.put("mensaje", "Usuario o Password Incorrecto");
			datos.put("path", "LoginController");
			respuesta.setDatos(datos);
			respuesta.setPaginaDestino("jsp/error.jsp");
			respuesta.setRedirect(false);
			//this.error(request, response);
		}
		return respuesta;
	}
	public RespuestaControlador salir(){
		respuesta.setDatos(null);
		respuesta.setPaginaDestino("jsp/login.jsp");
		respuesta.setRedirect(true);
		return respuesta;
	}
}
