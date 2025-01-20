package com.example.demo.respository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AutorRepositoryImpl implements AutorRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Autor> getAutores(){
		Query<Autor> query = (Query<Autor>) manager.createQuery("select a from Autor a", Autor.class);
		return query.getResultList();
	}

}
