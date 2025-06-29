package modelo.dao;

import java.util.List;

import modelo.Persona;

public interface PersonaDAO {
	
	public Persona autorizar(String nombre, String clave);
	
	public List<Persona> getPersonas();
	public Persona getPersonaById(int IdPersona);
	public void create(Persona persona);
	public void delete(int idPersona);
	public void update(Persona persona);
}
