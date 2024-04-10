package Ejercicio_4_repaso;

import java.time.LocalDate;

public class LibroFisico extends Libro{
	private int anchura;
	private int altura;
	private int peso;
	
	public LibroFisico(String titulo, String autor, LocalDate fechaEdicion, int numPaginas, int anchura, int altura, int peso) {
		super(titulo, autor, fechaEdicion, numPaginas);
		this.anchura = anchura;
		this.altura = altura;
		this.peso = peso;
	}

	public int getAnchura() {
		return anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	@Override
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
