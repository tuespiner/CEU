package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

@Repository
public interface EstudianteRepository {
	
	List<Estudiante> getEstudiantes();
	
	Estudiante getEstudiante(int id);
	
	void saveEstudiante(Estudiante estudiante);

}
