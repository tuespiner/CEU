package Ejercicio_10.Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {
	
	public Connection getNewConnection() throws SQLException{
		String usuario = "conexionbbddprog";
		String password = "a123456";
		
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName(driverClass);
		}catch(ClassNotFoundException e) {
			System.err.println("No se encuentra el driver JDBC. Revisa su configuración");
			throw new RuntimeException(e);
		}
		
		Connection conn = DriverManager.getConnection(url, usuario, password);
		return conn;
	}
}
