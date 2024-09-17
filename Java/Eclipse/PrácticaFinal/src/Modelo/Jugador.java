package Modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Jugador {
	private Integer numero;
	private String codigoEquipo;
	private String nombre;
	private LocalDate nacimiento;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCodigoEquipo() {
		return codigoEquipo;
	}
	public void setCodigoEquipo(String codigoEquipo) {
		this.codigoEquipo = codigoEquipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
	public BigDecimal getEdad() {
		Period periodo = LocalDate.now().until(this.nacimiento);
		BigDecimal edad = new BigDecimal(periodo.getYears());
		return edad;
	}
	@Override
	public String toString() {
		return " - "+this.nombre+" - "+this.nacimiento.toString();
	}
	
	
}
