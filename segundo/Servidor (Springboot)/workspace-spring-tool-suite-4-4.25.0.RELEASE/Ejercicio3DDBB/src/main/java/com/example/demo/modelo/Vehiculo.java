package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="marca")
	private String marca;
	@Column(name="modelo")
	private String modelo;
	@Column(name="anyo")
	private Integer anyo;
	@Column(name="matriucla")
	private String matricula;
	@Column(name="estado")
	private String estado;
	@Column(name="kilometraje")
	private Double kilometraje;
	
	
	public Vehiculo(Integer id, String marca, String modelo, Integer anyo, String matricula, String estado, Double kilometraje) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anyo = anyo;
		this.matricula = matricula;
		this.estado = estado;
		this.kilometraje = kilometraje;
	}
	public Vehiculo() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAnyo() {
		return anyo;
	}
	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(Double kilometraje) {
		this.kilometraje = kilometraje;
	}
	
	

}
