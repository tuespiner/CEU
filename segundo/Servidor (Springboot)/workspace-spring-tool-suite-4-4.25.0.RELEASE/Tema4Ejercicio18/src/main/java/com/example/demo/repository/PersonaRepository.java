package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Persona;

@Repository
public interface PersonaRepository {
	public void savePersona(Persona persona);
	public Persona getPersona(int id);
	public List<Persona> getPersonas();
}
