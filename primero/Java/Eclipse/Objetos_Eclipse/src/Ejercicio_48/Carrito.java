package Ejercicio_48;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carrito {
	private LocalDate fechaCreacion;
	private LocalDate fechaUltimaActualizacion;
	private Cliente cliente;
	private Set<Articulos> listaArticulos;
	
	public Carrito(Cliente cliente) {
		this.fechaCreacion = LocalDate.now();
		this.fechaUltimaActualizacion = LocalDate.now();
		this.cliente = cliente;
		this.listaArticulos = new HashSet<>();
	}
	
	public Carrito() {
		this.fechaCreacion = LocalDate.now();
		this.fechaUltimaActualizacion = LocalDate.now();
		this.listaArticulos = new HashSet<>();
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

	public Set<Articulos> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(Set<Articulos> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	
	public Integer getCantidad() {
		return this.listaArticulos.size();
	}
	
	public Double getTotal() {
		if (this.listaArticulos.size() == 0) {
			return null;
		}else {
			Double total = 0.0;
			for(Articulos articulo : listaArticulos) {
				total += articulo.getPrecio(); 
				
			}
			return total;
		}
	}
	
	public Double getPrecioMedio() {
		if (this.listaArticulos.size() == 0) {
			return null;
		}else {
			Double total = 0.0;
			for(Articulos articulo : listaArticulos) {
				total += articulo.getPrecio(); 
				
			}
			return total/this.listaArticulos.size();
		}
	}
	
	public void addArticulo(Articulos articulo) {
		if(this.listaArticulos.add(articulo) == true) {
			this.fechaUltimaActualizacion = LocalDate.now();
		}
	}

	public void borrarArticulo(Articulos articulo) {
		if(this.listaArticulos.remove(articulo)== true) {
			this.fechaUltimaActualizacion = LocalDate.now();
		}
		
	}
	
	public void vaciarCesta() {
		this.listaArticulos.clear();
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Carrito [fechaUltimaActualizacion=" + fechaUltimaActualizacion.format(formato)
				+ ", cliente=" + cliente + ", listaArticulos=" + listaArticulos + ", suma del total a pagar="+ this.getTotal()+"]";
	}
	
	
}
