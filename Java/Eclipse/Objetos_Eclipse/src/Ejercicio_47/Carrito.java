package Ejercicio_47;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private LocalDate fechaCreacion;
	private LocalDate fechaUltimaActualizacion;
	private Cliente cliente;
	private List<Articulos> listaArticulos;
	
	public Carrito(Cliente cliente) {
		this.fechaCreacion = LocalDate.now();
		this.fechaUltimaActualizacion = LocalDate.now();
		this.cliente = cliente;
		this.listaArticulos = new ArrayList<>();
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(LocalDate fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Articulos> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulos> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	
	public Integer getCantidad() {
		return this.listaArticulos.size();
	}
	
	public Double getTotal() {
		
	}
}
