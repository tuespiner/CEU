package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstudianteServiceImp implements EstudianteService{

	@Autowired
	private EstudianteRepository repo;

	@Override
	public List<Estudiante> getEstudiantes() {
		return repo.getEstudiantes();
	}

	@Override
	public Estudiante getEstudiante(int id) {
		return repo.getEstudiante(id);
	}

	@Override
	public void saveEstudiante(Estudiante estudiante) {
		repo.saveEstudiante(estudiante);
	}

	@Override
	public void actualizarEmailEstudiante(int id, String email) {
		Estudiante estudiante = getEstudiante(id);
		estudiante.setEmail(email);
		saveEstudiante(estudiante);
	}

	@Override
	public List<Estudiante> getEstudiantesCadEspecifica(String cad) {
		List<Estudiante> estudiantes = getEstudiantes();
		estudiantes.stream().filter(e -> e.getNombre().contains(cad));
		return estudiantes;
	}
}
