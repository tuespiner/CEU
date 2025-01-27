package com.example.demo.respository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Autor;
import com.example.demo.model.Libro;

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
<<<<<<< HEAD
	public Autor getAutor(int id) {
		return manager.find(Autor.class, id);
	}

	@Override
=======
>>>>>>> be0434bc7a2f9f070aaca12adafbb01e273dc247
	public void saveAutor(Autor autor) {
		manager.persist(autor);
	}

	@Override
<<<<<<< HEAD
=======
	public Autor getAutor(int id) {
		return manager.find(Autor.class, id);
	}

	@Override
>>>>>>> be0434bc7a2f9f070aaca12adafbb01e273dc247
	public void refreshAutor(Autor autor) {
		manager.merge(autor);
	}

	@Override
	public void deleteAutor(int id) {
		manager.remove(getAutor(id));
	}

<<<<<<< HEAD
	@Override
	public void insertLibro(Libro libro, int id) {
		getAutor(id).getLibros().add(libro);
	}

	@Override
	public void deleteLibroAutor(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Libro> getLibros() {
		Query<Libro> query = (Query<Libro>) manager.createQuery("select l from Libro l", Libro.class);
		return query.getResultList();
	}

=======
>>>>>>> be0434bc7a2f9f070aaca12adafbb01e273dc247
}
