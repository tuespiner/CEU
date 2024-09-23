package Ejercicio_15.Servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio_15.Modelo.Pedido;
import Ejercicio_15.Modelo.PedidoLinea;

public class PedidosService {

	private OpenConnection OpenConn;
	
	public PedidosService() {
		this.OpenConn = new OpenConnection();
	}
	
	public List<PedidoLinea> consultarLineasPedido(Integer numPedido) throws SQLException {
		ResultSet rs = null;
		List<PedidoLinea> listaLinea = new ArrayList<>();
		try (Connection conn = OpenConn.getNewConnection();
				Statement stmt = conn.createStatement()) {
			rs = stmt.executeQuery("select * from pedidos_lineas where numero_pedido = "+numPedido);
			while(rs.next()) {
				listaLinea.add(rsAPedidoLinea(rs));
			}
			return listaLinea;
		}
		
	}
	
	public Pedido consultarPedidoCompleto(Integer numPedido) throws PedidoException, NotFoundException{
		ResultSet rs = null;
		String query = "select * from pedidos where numero = ?";
		try (Connection conn = OpenConn.getNewConnection();
				PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, numPedido);
			rs = stmt.executeQuery();
			if(rs == null) {
				throw new NotFoundException();
			}
			return rsAPedido(rs);
			
		}catch(SQLException e) {
			throw new PedidoException(e.getMessage());
		}
	}
	
	public void insertarLineaPedido(Connection conn, PedidoLinea pl) throws SQLException{
		String query = "insert into pedidos_lineas values(?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(query)){
			setValueLineaPedido(stmt, pl);
			stmt.execute();
		}
	}
	
	public void borrarPedido(Integer numero) throws SQLException, NotFoundException{
		
	}
	
	public void crearPedidoCompleto(Pedido p) throws PedidoException, SQLException{
		try (Connection conn = OpenConn.getNewConnection()) {
			try {
				conn.setAutoCommit(false);
				insertarDatosPedido(conn, p);
				for(PedidoLinea pl : p.getPedidoLinea()) {
					insertarLineaPedido(conn, pl);
				}
				conn.commit();
			}catch(SQLException e) {
				conn.rollback();
				throw new PedidoException(e.getMessage());
			}
			
		}
	}
	
	private void insertarDatosPedido(Connection conn, Pedido p) throws SQLException{
		String query = "insert into pedidos_lineas values(?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setInt(1, p.getNumero());
			stmt.setString(2, p.getCliente());
			stmt.setDate(3, Date.valueOf(p.getFechaEntrega()));
		}
	}
	private void setValueLineaPedido(PreparedStatement stmt, PedidoLinea pl) throws SQLException{
		stmt.setInt(1, pl.getNumeroPedido());
		stmt.setString(2, pl.getArticulo());
		stmt.setInt(3, pl.getCantidad());
		stmt.setBigDecimal(4, pl.getPrecioUnitario());
	}
	
	private Pedido rsAPedido(ResultSet rs) throws SQLException{
		Pedido pedido = new Pedido();
		pedido.setCliente(rs.getString("cliente"));
		pedido.setNumero(rs.getInt("numero"));
		pedido.setPedidoLinea(consultarLineasPedido(pedido.getNumero()));
		pedido.setFechaEntrega(rs.getDate("fecha_entrega").toLocalDate());
		return pedido;
	}
	
	private PedidoLinea rsAPedidoLinea(ResultSet rs) throws SQLException{
		PedidoLinea linea = new PedidoLinea();
		linea.setArticulo(rs.getString("articulo"));
		linea.setCantidad(rs.getInt("cantidad"));
		linea.setNumeroPedido(rs.getInt("numero_pedido"));
		linea.setPrecioUnitario(rs.getBigDecimal("precio_unitario"));
		return linea;
	}
}
