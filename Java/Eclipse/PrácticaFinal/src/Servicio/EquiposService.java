package Servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Equipo;
import Modelo.Jugador;

public class EquiposService {
	private OpenConnection OpenConn;
	
	public EquiposService() {
		this.OpenConn = new OpenConnection();
	}
	
	public List<Equipo> consultarEquipos() throws EquipoServiceException{
		List<Equipo> listaEquipos = new ArrayList<>();
		String query = "select * from equipo";
		ResultSet rs = null;
		try (Connection conn = OpenConn.getNewConnection(); Statement stmt = conn.createStatement()){
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				listaEquipos.add(crearEquipoRs(rs));
			}
			return listaEquipos;
		}catch(SQLException e) {
			throw new EquipoServiceException(e.getMessage());
		}
	}
	public Equipo crearEquipoRs(ResultSet rs) throws SQLException {
		Equipo e = new Equipo();
		while(rs.next()) {
			e.setCodigo(rs.getString("CODIGO"));
			e.setNombre(rs.getString("NOMBRE"));
		}
		return e;
	}
	
	public List<Jugador> consultarJugadoresEquipo(String codigoEquipo) throws SQLException{
		List<Jugador> listaJugadores = new ArrayList<>();
		String query = "select * from jugador where codigo_equipo = ?";
		ResultSet rs = null;
		try (Connection conn = OpenConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setString(1, codigoEquipo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				listaJugadores.add(crearJugador(rs));
			}
			return listaJugadores;
		}
	}
	public Jugador crearJugador(ResultSet rs) throws SQLException {
		Jugador j = new Jugador();
		j.setNumero(rs.getInt("numero"));
		j.setCodigoEquipo(rs.getString("codigo_equipo"));
		j.setNombre(rs.getString("nombre"));
		j.setNacimiento(rs.getDate("nacimiento").toLocalDate());
		return j;
	}
	
	public Equipo consultarEquipoCompleto(String codigoEquipo) throws NotFoundException, EquipoServiceException {
		String query = "select * from equipo where codigo like ?";
		ResultSet rs = null;
		try (Connection conn = OpenConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setString(1, codigoEquipo);
			rs = stmt.executeQuery();
			Equipo equipoCompleto = crearEquipoRs(rs);
			equipoCompleto.setJugadores(consultarJugadoresEquipo(codigoEquipo));
			return equipoCompleto;
		}catch(SQLException e) {
			throw new NotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new EquipoServiceException(e.getMessage());
		}
	}
	
	public void insertarJugador(Connection conn, Jugador j) throws SQLException {
		String query = "insert into jugador values(?, ?, ?, ?)";
		try(PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setInt(1, j.getNumero());
			stmt.setString(2, j.getCodigoEquipo());
			stmt.setString(3, j.getNombre());
			stmt.setDate(4, Date.valueOf(j.getNacimiento()));
			stmt.execute();
		}
	}
	
	public void crearEquipo(Equipo equipo) throws EquipoServiceException {
		int contador = 1;
		String query = "insert into equipo values (?, ?)";
		try (Connection conn = OpenConn.getNewConnection(); PreparedStatement stmt = conn.prepareStatement(query)){
			conn.setAutoCommit(false);
			try {
				stmt.setString(1, equipo.getCodigo());
				stmt.setString(2, equipo.getNombre());
				stmt.execute();
				for(Jugador j : equipo.getJugadores()) {
					j.setNumero(contador);
					insertarJugador(conn, j);
				}
				conn.commit();
			}catch(SQLException e) {
				conn.rollback();
				throw new Exception(e.getMessage());
			}
			
		}catch(Exception e) {
			throw new EquipoServiceException(e.getMessage());
		}
	}
	
	public void borrarEquipoCompleto(String codigoEquipo) throws NotFoundException, EquipoServiceException {
		try(Connection conn = OpenConn.getNewConnection()){
			conn.setAutoCommit(false);
			try {
				borrarEquipo( conn,  codigoEquipo);
				borrarJugadores( conn,  codigoEquipo);
				conn.commit();
			}catch(SQLException e) {
				conn.rollback();
				throw new NotFoundException(e.getMessage());
			}
		}catch(NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}catch(Exception e) {
			throw new EquipoServiceException(e.getMessage());
		}
	}
	public void borrarJugadores(Connection conn, String codigoEquipo) throws SQLException {
		String query = "delete from jugador where codigo_equipo = ?";
		try(PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setString(1, codigoEquipo);
			stmt.execute();
		}
	}
	public void borrarEquipo(Connection conn, String codigoEquipo) throws SQLException {
		String query = "delete from equipo where codigo = ?";
		try(PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setString(1, codigoEquipo);
			stmt.execute();
		}
	}
	
	public void añadirJugadorAEquipo(Equipo equipo, Jugador jugador) throws EquipoServiceException {
		try (Connection conn = OpenConn.getNewConnection()){
			Integer numero = 1;
			jugador.setCodigoEquipo(equipo.getCodigo());
			List<Jugador> listaJuadores = consultarJugadoresEquipo(equipo.getCodigo());
			if(listaJuadores != null) {
				for(Jugador j : listaJuadores) {
					if(numero <= j.getNumero()) {
						numero = j.getNumero();
					}
				}
			}
			jugador.setNumero(numero + 1);
			insertarJugador(conn, jugador);
		}catch(Exception e) {
			throw new EquipoServiceException(e.getMessage());
		}
	}
	
	public void exportarJugadores(String codigoEquipo, String ruta) throws IOException, NotFoundException, EquipoServiceException, SQLException {
		List<Jugador> listaJugadores = consultarJugadoresEquipo(codigoEquipo);
		File fichero = new File(ruta);
		FileWriter writer = new FileWriter(fichero);
		int i = 1;
		for(Jugador j : listaJugadores) {
			writer.write(i+j.toString()+"\n");
			i++;
		}
		writer.close();
	}
}
