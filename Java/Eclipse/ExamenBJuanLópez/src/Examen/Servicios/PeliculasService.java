package Examen.Servicios;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Examen.Modelo.Pelicula;
import Examen.Modelo.PeliculaNotFoundException;

public class PeliculasService {
	private OpenConnection OpenConn;
	public PeliculasService() {
		this.OpenConn = new OpenConnection();
	}
	
	public List<Pelicula> consultarPeliculas(LocalDate fechIni, LocalDate fechaFin) throws  PeliculaNotFoundException, PeliculaErrorException{
		ResultSet rs = null;
		List<Pelicula> listaPeliculas = new ArrayList<>();
		String query = "select * from peliculas where estreno between ? and ?";
		try (Connection conn = OpenConn.getNewConnection();
				PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setDate(1, Date.valueOf(fechIni));
			stmt.setDate(2, Date.valueOf(fechaFin));
			rs = stmt.executeQuery();
			if(rs == null) {
				throw new PeliculaNotFoundException("No hay peliculas para estas fechas");
			}else{
				while(rs.next()) {
					Pelicula p = new Pelicula(rs.getString("titulo_pelicula"));
					p.setDuracion(rs.getInt("duracion"));
					p.setFechaEstreno(rs.getDate("estreno").toLocalDate());
					p.setFechaRodaje(rs.getDate("fecha_comienzo").toLocalDate());
					p.setPresupuestoIni(rs.getBigDecimal("presupuesto_inicial"));
					p.setRecaudacion(rs.getBigDecimal("recaudacion_acumulada"));
					listaPeliculas.add(p);
				}
				
			}
		}catch(SQLException e) {
			throw new PeliculaErrorException("Error consultando películas");
		}
		return listaPeliculas;
	}
	
	public Pelicula crearPeliculaRs(ResultSet rs) throws SQLException {
		Pelicula p = new Pelicula(rs.getString("titulo_pelicula"));
		p.setDuracion(rs.getInt("duracion"));
		p.setFechaEstreno(rs.getDate("estreno").toLocalDate());
		p.setFechaRodaje(rs.getDate("fecha_comienzo").toLocalDate());
		p.setPresupuestoIni(rs.getBigDecimal("presupuesto_inicial"));
		p.setRecaudacion(rs.getBigDecimal("recaudacion_acumulada"));
		return p;
	}
}
