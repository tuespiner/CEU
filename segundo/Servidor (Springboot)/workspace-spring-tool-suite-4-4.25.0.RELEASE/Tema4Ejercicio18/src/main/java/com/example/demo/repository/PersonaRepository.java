package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Persona;

@Repository
public interface PersonaRepository {
	public void savePersona(Persona persona);
	public Persona getPersona(int id);
}
