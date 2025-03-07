package com.example.demo.modelo;

public class Alumnos {
	private String id;
	private String nombre;
	private String email;
	private int edad;
	private Direccion direccion;
	
	public Alumnos(String id, String nombre,String email, int edad, Direccion direccion) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.direccion = direccion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
