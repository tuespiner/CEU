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

	@Override
	public void saveAutor(Autor autor) {
		manager.persist(autor);
	}

	@Override
	public Autor getAutor(int id) {
		return manager.find(Autor.class, id);
	}

	@Override
	public void refreshAutor(Autor autor) {
		manager.merge(autor);
	}

	@Override
	public void deleteAutor(int id) {
		manager.remove(getAutor(id));
	}

}
