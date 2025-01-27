package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EstudianteRepositoryImp implements EstudianteRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Estudiante> getEstudiantes() {
		Query<Estudiante> query = (Query<Estudiante>) manager.createQuery("select e from Estudiante e", Estudiante.class);
		return query.getResultList();
	}

	@Override
	public Estudiante getEstudiante(int id) {
		return manager.find(Estudiante.class, id);
	}

	@Override
	public void saveEstudiante(Estudiante estudiante) {
		if(getEstudiante(estudiante.getId()) == null) {
			manager.persist(estudiante);
		}else {
			manager.merge(estudiante);
		}
	}
}
