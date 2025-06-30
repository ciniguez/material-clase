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
	private static final String SQL_SELECT_ID = "SELECT * FROM PERSONA WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO persona (nombre, clave) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE PERSONA SET nombre = ?, clave = ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM PERSONA WHERE id = ?";
	private static final String SQL_AUTORIZAR = "SELECT * FROM PERSONA WHERE nombre = ? and clave = ?";

	public JDBCPersonaDAO() {

	}

	public List<Persona> getPersonas() {
		return null;
	}

	public Persona autorizar(String nombre, String clave) {
		Persona personaAutorizada = null;

		PreparedStatement pstmt;
		try {
			pstmt = ConexionBDD.getConexion().prepareStatement(SQL_AUTORIZAR);
			pstmt.setString(1, nombre);
			pstmt.setString(2, clave);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				personaAutorizada = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("clave"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personaAutorizada;

	}

	public Persona getPersonaById(int IdPersona) {
		// TU CODIGO AQUI
		return null;
	}

	public void create(Persona persona) {
		// TU CODIGO AQUI
	}

	public void delete(int idPersona) {
		// TU CODIGO AQUI
	}

	public void update(Persona persona) {
		// TU CODIGO AQUI
	}

}
