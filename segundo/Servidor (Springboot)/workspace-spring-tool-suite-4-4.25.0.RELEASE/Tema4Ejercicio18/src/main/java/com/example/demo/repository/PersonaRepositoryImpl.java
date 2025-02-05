package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void savePersona(Persona persona) {
		if(this.getPersona(persona.getId())!= null) {
			manager.merge(persona);
		}else {
			manager.persist(persona);
		}
	}

	@Override
	public Persona getPersona(int id) {
		return manager.find(Persona.class, id);
	}

	@Override
	public List<Persona> getPersonas() {
		Query<Persona> query = (Query<Persona>) manager.createQuery("select p from Persona p", Persona.class);
		return null;
	}
}
