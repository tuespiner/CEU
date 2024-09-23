package Ejercicio_4_repaso;

import java.time.LocalDate;

public class LibroDigital extends Libro{
	
	public LibroDigital(String titulo, String autor, LocalDate fechaEdicion, int numPaginas) {
		super(titulo, autor, fechaEdicion, numPaginas);
	}
	
	@Override
	public int getPeso() {
		return 0;
	}
}
