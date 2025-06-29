package controlador.frontcontroller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utilerias.RespuestaControlador;
import utilerias.Utilerias;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Utilerias utilerias = null;
	private RespuestaControlador respuesta = null;

	private Routes router;

	public FrontController() {
		utilerias = new Utilerias();
		System.out.println("Constructor de Front Controller");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombreRuta = (request.getParameter("ruta") != null) ? request.getParameter("ruta") : "inicio";

		System.out.println("FrontController ruta: " + nombreRuta);

		// Registrar las rutas en el Router
		Router.getInstance().addRoute("inicio", new Route("inicio", "inicio", false));
		Router.getInstance().addRoute("autenticar", new Route("autenticar", "autenticar", false));
		Router.getInstance().addRoute("listar", new Route("listar", "listarUsuarios", true));
		Router.getInstance().addRoute("nuevo", new Route("nuevo", "nuevoUsuario", true));
		Router.getInstance().addRoute("guardar", new Route("guardar", "guardarUsuario", true));
		Router.getInstance().addRoute("actualizar", new Route("actualizar", "actualizarUsuario", true));
		Router.getInstance().addRoute("eliminar", new Route("eliminar", "eliminarUsuario", true));
		Router.getInstance().addRoute("salir", new Route("salir", "salir", true));


		// Encontrar la ruta
		Route ruta = encontrarRuta(nombreRuta, Router.getInstance().getRutas());

		// Objeto de la Clase Routes que describe todas las rutas
		Routes rutas = new Routes(request);

		if (ruta != null) {
			respuesta = invocarMetodoDeControlador(ruta, rutas, request);
		} else {
			System.out.println("ERROR!: -- No se encontró Ruta: " + nombreRuta);
			respuesta = rutas.inicio();
		}

		// Llamar a la Vista
		if (respuesta != null) {
			utilerias.llamarVista(respuesta, request, response);
		} else {
			System.out.println("ERROR!: Respuesta desde el Controlador es NULO");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Encuentra la ruta especificada dentro de un Mapa de Rutas.
	 * 
	 * @param ruta      Nombre de Ruta a buscar
	 * @param mapaRutas Colección (Mapa) de rutas donde buscar el Nombre de Ruta.
	 * @return Objeto de tipo Ruta.
	 */
	private Route encontrarRuta(String ruta, HashMap<String, Object> mapaRutas) {

		Route rutaEncontrada = null;

		for (Entry<String, Object> entry : mapaRutas.entrySet()) {

			if (entry.getKey().equals(ruta)) {
				rutaEncontrada = (Route) entry.getValue();
				break;
			}
		}
		return rutaEncontrada;

	}

	/**
	 * Invoca (ejecuta) el método de la clase Routes que corresponde con el nombre
	 * del metodo registrado en la Ruta. Nota: Este método utiliza Java Reflextion.
	 * 
	 * @param ruta    Ruta
	 * @param rutas   Objeto de la clase Routes
	 * @param request Request del Servlet (necesario para validar la sesión activa).
	 * @return Respuesta del metodo invocado.
	 */
	private RespuestaControlador invocarMetodoDeControlador(Route ruta, Routes rutas, HttpServletRequest request) {

		RespuestaControlador respuesta = null;

		// Otener los metodos registrados en la clase Routes.
		Method[] metodos = rutas.getClass().getMethods();

		// Buscar el método de la Clase Routes que corresponde con el nombre del método
		// de la Ruta.
		for (Method m : metodos) {
			if (m.getName().equals(ruta.getMetodo())) {

				try {

					if (ruta.isValidarAutorizacion()) {

						if (utilerias.existeSesionActiva(request))

							respuesta = (RespuestaControlador) m.invoke(rutas, null);

						else
							respuesta = rutas.inicio(); // TODO Cambiar a dinámico.

					} else {
						respuesta = (RespuestaControlador) m.invoke(rutas, null);
					}
					break;

				} catch (IllegalAccessException e) {
					System.out.println(e.getMessage());
				} catch (InvocationTargetException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		return respuesta;

	}
}
