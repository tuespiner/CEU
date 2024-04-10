package Ejercicio_4_repaso;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
	private String direccion;
	private int numeroTel;
	private List<Libro> listaLibros;
	
	public Libreria(String direccion, int numeroTel) {
		this.direccion = direccion;
		this.numeroTel = numeroTel;
		this.listaLibros= new ArrayList<>();
	}
	
	public Libro obtenerLibroMasAntigui() {
		Libro masAntiguo = listaLibros.get(0);
		for(Libro libro : listaLibros) {
			if(libro.getFechaEdicion().isBefore(masAntiguo.getFechaEdicion())) {
				masAntiguo = libro;
			}
		}
		return masAntiguo;
	}
	
	public int obtenerPesoTotalDeLibros() {
		int total = 0;
		for(Libro libro : listaLibros) {
			total += libro.getPeso();
		}
		
		return total;
	}
	
	public int obtenerNumPaginasMedio() {
		int total = 0;
		for(Libro libro : listaLibros) {
			total +=libro.getNumPaginas();
		}
		
		total = total / listaLibros.size();
		
		return total;
	}
	
	
	
}
