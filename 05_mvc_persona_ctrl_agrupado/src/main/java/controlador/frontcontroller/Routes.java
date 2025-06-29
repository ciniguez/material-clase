package controlador.frontcontroller;


import controlador.autorizar.LoginController2;
import controlador.gestionpersona.GestionarPersonaController2;
import jakarta.servlet.http.HttpServletRequest;
import utilerias.RespuestaControlador;

public class Routes {

	private HttpServletRequest request;
	
	public Routes (HttpServletRequest request) {
		this.request = request;
		
	}
	
	public RespuestaControlador autenticar() {
		LoginController2 login = new LoginController2();
		String nombre = request.getParameter("usuario");
		String password = request.getParameter("password");
		return login.ingresar(nombre, password, request.getSession());
	
	}

	public RespuestaControlador actualizarUsuario() {
		int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		GestionarPersonaController2 ctrl = new GestionarPersonaController2();
		return ctrl.actualizar(idPersona);
	}

	public RespuestaControlador eliminarUsuario() {
		int id =  Integer.parseInt(request.getParameter("idPersona"));		
		GestionarPersonaController2  ctrl = new GestionarPersonaController2();
		return ctrl.eliminar(id);
	}

	public RespuestaControlador guardarUsuario() {
		// 1.- Obtengo parámetros
		int id = (request.getParameter("txtId") == "") ? 0 : Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombre");
		String clave = request.getParameter("txtClave");
		
		GestionarPersonaController2 ctrl = new GestionarPersonaController2();
		return ctrl.guardar(id, nombre, clave);
	}

	public RespuestaControlador nuevoUsuario() {
		GestionarPersonaController2 ctrl = new GestionarPersonaController2();
		return ctrl.nuevo();

	}

	public RespuestaControlador listarUsuarios() {
		GestionarPersonaController2 ctrl = new GestionarPersonaController2();
		return ctrl.listar();
	}

	public RespuestaControlador inicio() {
		LoginController2 login = new LoginController2();
		return login.inicio();

	}

	public RespuestaControlador salir() {
		
		request.getSession().invalidate(); // Importante ponerlo en este lugar. No en el metodo del controaldor.
		
		LoginController2 login = new LoginController2();
		return login.salir();
	}
	
	

}
