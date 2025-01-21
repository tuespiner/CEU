package com.example.demo.serviece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Autor;
import com.example.demo.model.Libro;
import com.example.demo.respository.AutorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutorServiceImpl implements AutorService{
	
	@Autowired
	private AutorRepository repo;
	
	@Override
	public List<Autor> getAutores(){
		return repo.getAutores();
	}

	@Override
	public void saveAutor(Autor autor) {
		repo.saveAutor(autor);
	}

	@Override
	public Autor getAutor(int id) {
		return repo.getAutor(id);
	}

	@Override
	public void refreshAutor(Autor autor) {
		repo.refreshAutor(autor);
	}

	@Override
	public void deleteAutor(int id) {
		repo.deleteAutor(id);
	}

	@Override
	public void addLibroAutor(Libro libro, int id) {
		Autor autor = repo.getAutor(id);
		if(autor != null) {
			autor.getLibros().add(libro);
			repo.refreshAutor(autor);
		}
	}

	@Override
	public void deleteLibroAutor(int id, int libro) {
		Autor autor = repo.getAutor(id);
		if(autor != null) {
			autor.getLibros().stream().filter(l -> l.getId() != libro);
		}
		
	}

	@Override
	public List<Libro> getLibrosAutor(int id) {
		Autor autor = repo.getAutor(id);
		if(autor != null) {
			return autor.getLibros();
		}
		return null;
	}
}
