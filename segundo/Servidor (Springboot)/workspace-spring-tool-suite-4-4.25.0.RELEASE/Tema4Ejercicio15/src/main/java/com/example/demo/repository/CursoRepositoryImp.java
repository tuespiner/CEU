package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CursoRepositoryImp implements CursoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void saveCurso(Curso curso) {
		Curso estaCurso = getCurso(curso.getId());
		if(estaCurso == null) {
			manager.persist(curso);
		}else {
			manager.merge(curso);
		}
	}

	@Override
	public Curso getCurso(int id) {
		return manager.find(Curso.class, id);
	}

	@Override
	public List<Curso> getCursos() {
		Query<Curso> query = (Query<Curso>) manager.createQuery("select c from Curso c", Curso.class);
		return query.getResultList();
	}

	@Override
	public void deleteCurso(int id) {
		manager.remove(getCurso(id));
	}
}
