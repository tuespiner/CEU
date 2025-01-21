package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface CursoService {
	
	void saveCurso(Curso curso);
	
	Curso getCurso(int id);
	
	void saveEstudianteCurso(Estudiante estudiante, int id);
	
	List<Curso> getCursos();
	
	List<Curso> getCursosUnaPalabra();
	
	void deleteCurso(int id);
	
	void deleteEstudianteCurso(int id_estudiante, int id_curso);
}
