package com.example.demo.serviece;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Autor;
import com.example.demo.model.Libro;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface AutorService {
	
	List<Autor> getAutores();
	
	void saveAutor(Autor autor);
	
	void refreshAutor(Autor autor);
	
	void deleteAutor(int id);
	
	void insertLibro(Libro libro, int id);
	
	void deleteLibroAutor(Libro libro);
	
	List<Libro> getLibros();
}
