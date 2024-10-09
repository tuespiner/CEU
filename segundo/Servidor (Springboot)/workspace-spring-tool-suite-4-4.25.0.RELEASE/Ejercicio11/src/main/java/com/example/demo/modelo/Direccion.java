package com.example.demo.modelo;

public class Direccion {
	private String calle;
	private Integer codigoPostal;
	private String ciudad;
	
	public Direccion(String calle, Integer codigoPostal, String ciudad) {
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
