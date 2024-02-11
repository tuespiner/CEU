package Ejercicio_47;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		this.listaArticulos.add(articulo);
	}

	public void borrarArticulo(Integer num) {
		if(this.listaArticulos.size() >= 0) {
			this.listaArticulos.remove(num);
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
