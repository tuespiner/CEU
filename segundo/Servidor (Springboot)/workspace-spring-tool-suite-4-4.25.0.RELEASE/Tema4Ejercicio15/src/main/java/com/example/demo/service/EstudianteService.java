package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface EstudianteService {
	
	List<Estudiante> getEstudiantes();
	
	Estudiante getEstudiante(int id);
	
	void saveEstudiante(Estudiante estudiante);
	
	void actualizarEmailEstudiante(int id, String email);
	
	List<Estudiante> getEstudiantesCadEspecifica(String cad);
}
