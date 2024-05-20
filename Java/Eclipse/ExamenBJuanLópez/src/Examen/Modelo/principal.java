package Examen.Modelo;

import java.math.BigDecimal;

public class principal extends Actor{
	private Pelicula peliculaDebut;
	
	
	public principal(String nombreArtistico) {
		super(nombreArtistico);
		// TODO Auto-generated constructor stub
	}
	public Pelicula getPeliculaDebut() {
		return peliculaDebut;
	}

	public void setPeliculaDebut(Pelicula peliculaDebut) {
		this.peliculaDebut = peliculaDebut;
	}

	@Override
	public BigDecimal getCoste() {
		return this.getCache();
	}

	
	
}
