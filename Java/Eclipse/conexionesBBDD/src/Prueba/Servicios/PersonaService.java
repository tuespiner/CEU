package Prueba.Servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Prueba.Modelo.Persona;

public class PersonaService {
	
	private OpenConnection OpenConn;
	
	public PersonaService() {
		this.OpenConn = new OpenConnection();
	}
	
	public Persona consultarPersona(String dni) throws SQLException{
		ResultSet rs = null;
		try(Connection conn = OpenConn.getNewConnection();		//1) Estas dos líneas son para hacer la conexión y el statement 
			Statement stmt = conn.createStatement()) {			//y que se cierren automáticamente.
			
			rs = stmt.executeQuery("select * from personas where dni = '" + dni + "'");  //1) Aquí se pone la query que queremos de sql.
			
			if(rs.next()) {							//1) Aquí básicamente lee el dato y da un resultado dependiendo si esta bacío 
				return this.setPersonaRs(rs);		//para que no de ninguna excepción.
			}else {
				return null;
			}
		}
	}
	
	public void añadirPersona(Persona p) throws SQLException{
		try (Connection conn = OpenConn.getNewConnection();
			 PreparedStatement stmt = conn.prepareStatement("INSERT INTO personas VALUES(?,?,?,?)")){	//2) El PreparedStatement es para
																										//las querys insert, update y delete, 					
			this.setInfoStatementPersona(stmt, p);														//la query que queremos ejecutar también
			stmt.executeUpdate();																		//lo ponemos aquí
		}
	}
	
	public void setInfoStatementPersona(PreparedStatement stmt, Persona p)  throws SQLException{	//2) Aquí básicamente se le ponen los datos 
		stmt.setString(1,p.getDni());																//que queremos insertar en la query
		stmt.setString(2,p.getNombre());
		stmt.setString(3,p.getApellidos());
		stmt.setDate(4,p.getFechaService());
	}
	
	public Persona setPersonaRs(ResultSet rs) throws SQLException{		//1) Aquí creamos la persona con los datos que hemos obtenido de la query
		Persona p = new Persona();										
		p.setNombre(rs.getString("NOMBRE"));
		p.setDni(rs.getString("DNI"));
		p.setApellidos(rs.getString("APELLIDOS"));
		p.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
		return p; 
	}
	
}
