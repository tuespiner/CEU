package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pasaporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "numero")
	 private int numero;
	@OneToOne(mappedBy = "pasaporte")
	private Persona persona;
	
	public Pasaporte() {
		
	}
	
	public Pasaporte(int numero, Persona persona) {
		this.numero = numero;
		this.persona = persona;
	}
}
