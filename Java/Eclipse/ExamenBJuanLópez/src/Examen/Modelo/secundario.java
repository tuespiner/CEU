package Examen.Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class secundario extends Actor{
	public secundario(String nombreArtistico) {
		super(nombreArtistico);
		// TODO Auto-generated constructor stub
	}

	private Integer porcentajeDedicacion;

	public Integer getPorcentajeDedicacion() {
		return porcentajeDedicacion;
	}

	public void setPorcentajeDedicacion(Integer porcentajeDedicacion) {
		this.porcentajeDedicacion = porcentajeDedicacion;
	}

	@Override
	public BigDecimal getCoste() {
		BigDecimal coste = BigDecimal.ZERO;
		coste = coste.multiply(new BigDecimal("0."+this.porcentajeDedicacion));
		return coste.setScale(2,RoundingMode.HALF_DOWN);
	}
	
	
}
