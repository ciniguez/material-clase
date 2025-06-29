package controlador.gestionpersona;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GestionarPersonaController")
public class GestionarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestionarPersonaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.rutear(request, response);
	}

	private void rutear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ruta = (request.getParameter("ruta") == null) ? "listar" : request.getParameter("ruta");

		switch (ruta) {
		case "listar":
			this.listar(request, response);
			break;
		case "nuevo":
			this.nuevo(request, response);
			break;
		case "guardar":
			this.guardar(request, response);
			break;
		case "actualizar":
			this.actualizar(request, response);
			break;
		case "eliminar":
			this.eliminar(request, response);
			break;
		default:
			this.listar(request, response);
			break;
		}

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
