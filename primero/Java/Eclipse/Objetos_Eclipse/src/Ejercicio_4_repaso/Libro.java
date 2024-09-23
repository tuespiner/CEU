package Ejercicio_4_repaso;

import java.time.LocalDate;

public abstract class Libro {
	private String titulo;
	private String autor;
	private LocalDate fechaEdicion;
	private int numPaginas;
	
	public Libro(String titulo, String autor, LocalDate fechaEdicion, int numPaginas) {
		this.autor = autor;
		this.fechaEdicion = fechaEdicion;
		this.numPaginas = numPaginas;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	public abstract int getPeso();	
	
	
}
