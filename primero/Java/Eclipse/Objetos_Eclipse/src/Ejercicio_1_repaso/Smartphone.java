package Ejercicio_1_repaso;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;

public class Smartphone {
	private String marca;
	private String modelo;
	private String imei;
	private BigDecimal precio;
	private LocalDate fechaFabricacion;
	private Boolean activo;
	
	public Smartphone() {
		this.precio = BigDecimal.ZERO;
		this.activo = true;
	}
	
	public Smartphone(String imei) {
		this.imei = imei;
		this.precio = BigDecimal.ZERO;
		this.activo = true;
	}
	
	public Smartphone(String imei, String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		this.imei = imei;
		this.precio = BigDecimal.ZERO;
		this.activo = true;
	}
	
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	public void activar() {
		this.activo = true;
	}
	
	public void desactivar() {
		this.activo = false;
	}
	
	public Integer getEdad() {
		LocalDate primeraFecha = LocalDate.of(2000, 4,1);
		Period periodo = primeraFecha.until(this.fechaFabricacion);
		return periodo.getYears();
	}
	
	public void cambiarMarcaModelo(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public void establecerFabricación(LocalDate fecha) {
		this.fechaFabricacion = fecha;
	}
	
	public BigDecimal getPrecioMasIva() {
		BigDecimal iva = new BigDecimal(1.21);
		BigDecimal decimalIva = this.precio.multiply(iva).setScale(2,RoundingMode.HALF_DOWN);
		return decimalIva;
	}
	
	public Boolean isAltaGama(BigDecimal precioBase) {
		if(precioBase.compareTo(this.precio) > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean isDatosCompletos() {
		if(this.marca == null || this.marca.isBlank()) {
			return false;
		}else if (this.imei == null || this.marca.isBlank()) {
			return false;
		}else if (this.modelo == null || this.marca.isBlank()) {
			return false;
		}else if (this.precio == null) {
			return false;
		}else if (this.activo == null) {
			return false;
		}else if(this.fechaFabricacion == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public Boolean isGratis() {
		if(this.precio.doubleValue() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void rebajar() {
		this.precio = this.precio.min(BigDecimal.TEN);
	}

	@Override
	public String toString() {
		String activo;
		if(this.activo == true) {
			return "[" + marca + "(" + modelo+ ")]";
		}else {
			return "[" + marca + "(" + modelo+ ") - INACTIVO]";
		}
	}
	
	
}
