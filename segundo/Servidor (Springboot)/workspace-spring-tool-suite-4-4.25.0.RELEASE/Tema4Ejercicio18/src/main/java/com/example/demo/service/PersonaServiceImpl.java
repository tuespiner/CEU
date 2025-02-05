package com.example.demo.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository repo;

	@Override
	public void savePersona(Persona persona) {
		repo.savePersona(persona);
	}
	
	@Override
	public void eliminarProyectopersona(Proyecto proyecto, int id) {
		Persona persona = this.getPersona(id);
		persona.getProyectos().stream().filter(p -> p.getId() != proyecto.getId()).collect(Collectors.toList());
		this.savePersona(persona);
	}

	@Override
	public Persona getPersona(int id) {
		return repo.getPersona(id);
	}
	
	
}
