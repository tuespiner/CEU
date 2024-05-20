package Examen.Modelo;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Actor {
	private String  nombreArtistico;
	private BigDecimal cache;
	
	public Actor(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
		this.cache = BigDecimal.ZERO;
	}
	
	public String getNombreArtistico() {
		return nombreArtistico;
	}
	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}
	public BigDecimal getCache() {
		return cache;
	}
	public void setCache(BigDecimal cache) {
		this.cache = cache;
	}

	public abstract BigDecimal getCoste();
		
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nombreArtistico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(nombreArtistico, other.nombreArtistico);
	}
	
	
}
