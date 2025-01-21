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
	
	Autor getAutor(int id);
	
	void saveAutor(Autor autor);
	
	void refreshAutor(Autor autor);
	
	void deleteAutor(int id);
	
	void addLibroAutor(Libro libro, int id);
	
	void deleteLibroAutor(int id, int libro);
	
	List<Libro> getLibrosAutor(int id);
}
