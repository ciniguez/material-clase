package test.controladores;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controlador.gestionpersona.GestionarPersonaController2;
import modelo.Persona;
import utilerias.RespuestaControlador;

class GestionarPersonaTest {

	private GestionarPersonaController2 controlador;
	private RespuestaControlador respuesta ;
	
	public GestionarPersonaTest() {
		controlador = new GestionarPersonaController2();
		respuesta = new RespuestaControlador();
	}
	
	@Test
	void listar() {
		//GIVEN: A user request to list users.
		respuesta =  controlador.listar();
		// WHEN
		
		//THEN
		@SuppressWarnings("unchecked")
		List<Persona> listaUsuarios = (List<Persona>) respuesta.getDatos().get("personas");
		assertEquals( 3, listaUsuarios.size(), "la lista de Usuarios NO es correcta");
		
	}

}
