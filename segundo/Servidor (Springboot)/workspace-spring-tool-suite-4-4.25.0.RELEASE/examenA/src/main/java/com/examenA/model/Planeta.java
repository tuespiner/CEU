package com.examenA.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Planeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "tipo")
	private String tipo;
	@OneToMany(mappedBy = "planeta")
	private List<Luna> lunas;
	
	public List<Luna> getLunas() {
		return lunas;
	}
	public void setLunas(List<Luna> lunas) {
		this.lunas = lunas;
	}
	public Planeta() {
		super();
		this.lunas = new ArrayList<Luna>();
	}
	public Planeta(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.lunas = new ArrayList<Luna>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
