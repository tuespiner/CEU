package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

@Repository
public interface CursoRepository {
	
	void saveCurso(Curso curso);
	
	Curso getCurso(int id);
	
	List<Curso> getCursos();
	
	void deleteCurso(int id);
}
