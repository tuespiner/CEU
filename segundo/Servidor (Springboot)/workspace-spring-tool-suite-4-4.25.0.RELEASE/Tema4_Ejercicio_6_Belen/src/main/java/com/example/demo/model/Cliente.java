package com.example.demo.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "direccion_id")
	private Direccion direccion;
	public Cliente() {
		
	}
	public Cliente(String nombre, Direccion direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Integer getId() {
		System.out.println(this.id);
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
