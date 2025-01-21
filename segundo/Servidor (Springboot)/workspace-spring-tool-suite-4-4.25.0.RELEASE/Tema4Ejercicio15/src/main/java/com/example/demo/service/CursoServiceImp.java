package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoServiceImp implements CursoService{

	@Autowired
	private CursoRepository repo;

	@Override
	public void saveCurso(Curso curso) {
		repo.saveCurso(curso);
	}

	@Override
	public Curso getCurso(int id) {
		return repo.getCurso(id);
	}

	@Override
	public void saveEstudianteCurso(Estudiante estudiante, int id) {
		Curso curso = getCurso(id);
		curso.getEstudiantes().add(estudiante);
		saveCurso(curso);
	}

	@Override
	public List<Curso> getCursos() {
		return repo.getCursos();
	}

	@Override
	public List<Curso> getCursosUnaPalabra() {
		List<Curso> cursosUnaPalabra = getCursos();
		cursosUnaPalabra.stream().filter(c -> c.getNombre().contains(" ") == false);
		return cursosUnaPalabra;
	}

	@Override
	public void deleteCurso(int id) {
		repo.deleteCurso(id);
	}

	@Override
	public void deleteEstudianteCurso(int id_estudiante, int id_curso) {
		Curso curso = getCurso(id_curso);
		curso.getEstudiantes().stream().filter(e -> e.getId() != id_estudiante);
		saveCurso(curso);
	}
}
