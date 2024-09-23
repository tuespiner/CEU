package Ejercicio_12.Modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Ejercicio_12.Servicios.PedidosService;


public class Pedido {
	private static PedidosService ps = new PedidosService();
	
	private Integer numero;
	private String cliente;
	private LocalDate fechaEntrega;
	private List<PedidoLinea> PedidoLinea;
	
	public Pedido() throws SQLException {
		this.PedidoLinea = new ArrayList<>();
		this.numero = ps.setNumP();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public List<PedidoLinea> getPedidoLinea() {
		return PedidoLinea;
	}

	public void setPedidoLinea(List<PedidoLinea> pedidoLinea) {
		PedidoLinea = pedidoLinea;
	}

	@Override
	public String toString() {
		String cad = "numero =" + numero + ", cliente =" + cliente + ", Fecha de entrega =" + fechaEntrega + ", Lineas del pedido =";
		for(PedidoLinea pl: this.PedidoLinea) {
			cad = cad + "/n/t" + pl;
		}
		return cad;
		
	}
	
	
	
	
}
