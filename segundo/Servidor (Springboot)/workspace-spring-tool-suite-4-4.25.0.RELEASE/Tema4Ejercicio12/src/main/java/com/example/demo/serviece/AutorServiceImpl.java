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
	public void refreshAutor(Autor autor) {
		repo.refreshAutor(autor);
		
	}

	@Override
	public void deleteAutor(int id) {
		repo.deleteAutor(id);
		
	}

	@Override
	public void insertLibro(Libro libro, int id) {
		repo.insertLibro(libro, id);
		
	}

	@Override
	public void deleteLibroAutor(Libro libro) {
		repo.deleteLibroAutor(libro);
		
	}

	@Override
	public List<Libro> getLibros() {
		return repo.getLibros();
	}
}
