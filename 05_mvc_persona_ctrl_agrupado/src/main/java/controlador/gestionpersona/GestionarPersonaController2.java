package controlador.gestionpersona;


import java.util.HashMap;

import modelo.Persona;
import utilerias.RespuestaControlador;

public class GestionarPersonaController2{

	private RespuestaControlador respuesta;
	public GestionarPersonaController2() {
		respuesta = new RespuestaControlador();
	}

	
	public RespuestaControlador guardar( int id, String nombre, String clave) {
		

		// 2.- Hablar con el Modelo
		Persona persona = new Persona(id, nombre, clave);		
		if (persona.getPersonaById(id) == null) {
			persona.create();
		} else {
			persona.update(nombre, clave);
		}

		// 3.- Navego a la vista
		respuesta.setDatos(null);
		respuesta.setPaginaDestino("FrontController?ruta=listar");
		respuesta.setRedirect(true);
		return respuesta;
//		response.sendRedirect("GestionarPersonaController?ruta=listar");

	}

	public RespuestaControlador eliminar(int id){
		
		Persona persona = new Persona();
		persona = persona.getPersonaById( id);
		
		try {
			persona.delete();
			
			respuesta.setDatos(null);
			respuesta.setPaginaDestino("FrontController?ruta=listar");
			respuesta.setRedirect(true);
			return respuesta;
		} catch (Exception e) {
			
			HashMap<String, Object> datos = new HashMap<String, Object>();
			datos.put("mensaje", e.getMessage());
			datos.put("path", "FrontController?ruta=listar");
			respuesta.setDatos(datos);
			
			respuesta.setPaginaDestino("FrontController?ruta=listar");
			
			respuesta.setRedirect(false);
			
		}
		return respuesta;
	}

	public RespuestaControlador actualizar(int id){
	

		Persona persona = new Persona();
		persona = persona.getPersona(id);
		
		HashMap<String, Object> datos = new HashMap<String, Object>();
		datos.put("persona", persona);
		
		respuesta.setDatos( datos);
		respuesta.setPaginaDestino("/jsp/actualizarPersona.jsp");
		respuesta.setRedirect(false);
		return respuesta;

	}

	public RespuestaControlador nuevo() {
		respuesta.setDatos(null);
		respuesta.setPaginaDestino("/jsp/insertarPersona.jsp");
		respuesta.setRedirect(false);
		return respuesta;
		//request.getRequestDispatcher("/jsp/insertarPersona.jsp").forward(request, response);

	}
	

	public RespuestaControlador listar(){
		
		Persona persona = new Persona();

		HashMap<String, Object> datos = new HashMap<String, Object>();
		datos.put("personas", persona.getPersonas());
		
		respuesta.setDatos(datos);
		
		respuesta.setRedirect(false);
		
		respuesta.setPaginaDestino("jsp/listarPersonas.jsp");
		
		return respuesta;
		
	}

}
