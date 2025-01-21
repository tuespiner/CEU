package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LibroRepositoryImpl implements LibroRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void saveLibro(Libro libro) {
		manager.persist(libro);
	}

	@Override
	public void refreshTitle(String titulo, int id) {
		
	}

}
