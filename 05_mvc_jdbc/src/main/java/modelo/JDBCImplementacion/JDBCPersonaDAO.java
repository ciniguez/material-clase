package modelo.JDBCImplementacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.PersonaDAO;
import modelo.Persona;
import modelo.conexion.ConexionBDD;

public class JDBCPersonaDAO implements PersonaDAO{
	private static final String SQL_SELECT = "SELECT * FROM PERSONA";
	private static final String SQL_SELECT_ID = "SELECT * FROM PERSONA WHERE idPersona = ?";
	private static final String SQL_INSERT = "INSERT INTO persona (nombre, clave) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE PERSONA SET nombre = ?, clave = ? WHERE idPersona = ?;";
	private static final String SQL_DELETE = "DELETE FROM PERSONA WHERE idPersona = ?";

	public JDBCPersonaDAO() {

	}

	public List<Persona> getPersonas() {
		// Variables a utilizar
		ResultSet rs = null;
		PreparedStatement pstm = null;

		List<Persona> personas = new ArrayList<Persona>();

		try {
			// Conectarse a la BDD
			pstm = ConexionBDD.getConexion().prepareStatement(SQL_SELECT);

			rs = pstm.executeQuery();

			while (rs.next()) {

				int idPersona = rs.getInt("idPersona");
				String nombre = rs.getString("nombre");
				String clave = rs.getString("clave");

				personas.add(new Persona(idPersona, nombre, clave));
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			ConexionBDD.cerrar(rs);
			ConexionBDD.cerrar(pstm);
			ConexionBDD.cerrar();
		}

		return personas;

	}

	public Persona autorizar(String nombre, String clave) {
		return null;

	}

	public Persona getPersonaById(int IdPersona) {
		return null;
	}

	public void create(Persona persona) {

	}

	public void delete(int idPersona) {

	}

	public void update(Persona persona) {
		
	}

}
