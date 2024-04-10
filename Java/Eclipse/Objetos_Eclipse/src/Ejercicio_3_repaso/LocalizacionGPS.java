package Ejercicio_3_repaso;

import java.math.BigDecimal;

public class LocalizacionGPS {
	private BigDecimal latitud;
	private BigDecimal longitud;
	
	public LocalizacionGPS() {
		
	}
	public LocalizacionGPS(BigDecimal latitud, BigDecimal longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}
	
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
	
	public BigDecimal getLatitud() {
		return this.latitud;
	}
	
	public BigDecimal getLongitud() {
		return this.longitud;
	}
}
