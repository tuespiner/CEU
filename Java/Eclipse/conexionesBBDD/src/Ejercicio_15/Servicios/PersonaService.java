package Ejercicio_15.Servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Ejercicio_15.Modelo.Persona;

public class PersonaService {

	private OpenConnection OpenConn;

	public PersonaService() {
		this.OpenConn = new OpenConnection();
	}

	public Persona consultarPersona(String dni) throws SQLException {
		ResultSet rs = null;
		try (Connection conn = OpenConn.getNewConnection(); // 1) Estas dos líneas son para hacer la conexión y el
															// statement
				Statement stmt = conn.createStatement()) { // y que se cierren automáticamente.

			rs = stmt.executeQuery("select * from personas where dni = '" + dni + "'"); // 1) Aquí se pone la query que
																						// queremos de sql.

			if (rs.next()) { // 1) Aquí básicamente lee el dato y da un resultado dependiendo si esta bacío
				return this.personaRs(rs); // para que no de ninguna excepción.
			} else {
				return null;
			}
		}
	}

	public void añadirPersona(Persona p) throws SQLException {
		try (Connection conn = OpenConn.getNewConnection();) {
			this.setInfoStatementPersona(p, conn);
		}
	}

	public Set<Persona> filtro(String cad) throws SQLException {
		ResultSet rs = null;
		Set<Persona> set = new HashSet<>();
		try (Connection conn = OpenConn.getNewConnection(); Statement stmt = conn.createStatement()) {
			rs = stmt.executeQuery(
					"select * from personas where nombre like '%" + cad + "%' or apellidos like '%" + cad + "%'");
			return set = this.setPersonaRs(rs);
		}

	}

	public void insertarPersonas(List<Persona> lista) throws SQLException {
		try (Connection conn = OpenConn.getNewConnection();) {
			conn.setAutoCommit(false);

			try {
				for (int i = 0; i < lista.size(); i++) {
					this.setInfoStatementPersona(lista.get(i), conn);
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}
		}
	}
	
	public void eliminarPersona(String dni) throws SQLException{
		String consulta = "delete  from personas where dni = ?";
		try (Connection conn = OpenConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(consulta)){
			stmt.setString(1, dni);
			stmt.execute();
		}catch (SQLException e) {
			throw e;
		}
	}

	public Integer borrarPersonasA() throws SQLException{
		Integer i = 0;
		for(String dni : this.getAdultos(this.filtro(""))) {
			this.eliminarPersona(dni);
			i++;
		}
		return i;
	}
	
	public void borrarPersonaB() throws SQLException{
		String consulta = "DELETE FROM personas WHERE FECHA_NACIMIENTO <= ADD_MONTHS(SYSDATE, -12*18)";
		try (Connection conn = OpenConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(consulta)){
			stmt.execute();
		}
	}
	
	public Set<String> getAdultos(Set<Persona> set) throws SQLException{
		Set<String> adultos = new HashSet<>();
		LocalDate fechaAdultos =  LocalDate.now().minusYears(18);
		for(Persona persona : set) {
			if(persona.getFechaNacimiento() != null && persona.getFechaNacimiento().compareTo(fechaAdultos) <= 0) {
				adultos.add(persona.getDni());
			}
		}
		return adultos;
	}

	public void setInfoStatementPersona(Persona p, Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO personas VALUES(?,?,?,?)");
		stmt.setString(1, p.getDni());
		stmt.setString(2, p.getNombre());
		stmt.setString(3, p.getApellidos());
		stmt.setDate(4, p.getFechaService());
		stmt.execute();
	}

	public Persona personaRs(ResultSet rs) throws SQLException {
		Persona p = new Persona();
		p.setNombre(rs.getString("NOMBRE"));
		p.setDni(rs.getString("DNI"));
		p.setApellidos(rs.getString("APELLIDOS"));
		if(rs.getDate("FECHA_NACIMIENTO") == null) {
			p.setFechaNacimiento(null);
		}else {
			p.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
		}
		return p;
	}
	
	public Integer ponerNumPedido() throws SQLException{
		Integer numero = 0;
		ResultSet rs = null;
		String consulta = "select numero from pedidos";
		try (Connection conn = OpenConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(consulta)){
			rs = stmt.executeQuery();
			while(rs.next()) {
				
			}
		}
		return numero;
	}

	public Set<Persona> setPersonaRs(ResultSet rs) throws SQLException { // 1) Aquí creamos la persona con los datos que
																			// hemos obtenido de la query
		Set<Persona> set = new HashSet<>();
		System.out.println(rs.getFetchSize());
		if (rs.getFetchSize() >= 1) {
			while (rs.next()) {
				set.add(this.personaRs(rs));
			}
		} else {
			set = null;
		}
		return set;

	}

}
