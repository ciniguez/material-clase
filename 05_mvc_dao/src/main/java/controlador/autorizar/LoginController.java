package controlador.autorizar;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.rutear(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.rutear(req, resp);
	}

	private void rutear(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String ruta = (request.getParameter("ruta") == null)?"inicio":request.getParameter("ruta");

		

		switch (ruta) {
		case "inicio":
			this.inicio(request, response);
			break;
		case "ingresar":
			this.ingresar(request, response);
			break;
		case "salir":
			this.salir(request, response);
			break;
		case "error":
			this.error(request, response);
			break;
		default:
			this.inicio(request, response);
			break;
		}
	}

	private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	}

	private void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				
	}

	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	}
}
