package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudiante {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "email")
	private String email;
	@ManyToMany
	
	private List<Curso> cursos;
	
	public Estudiante() {
		super();
	}
	public Estudiante(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
