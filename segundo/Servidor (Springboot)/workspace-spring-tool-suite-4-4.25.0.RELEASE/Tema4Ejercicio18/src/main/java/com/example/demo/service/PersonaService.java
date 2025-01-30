package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;

@Service
public interface PersonaService {
	public void savePersona(Persona persona);
	public Persona getPersona(int id);
	public void eliminarProyectopersona(Proyecto proyecto, int id);
	
}
