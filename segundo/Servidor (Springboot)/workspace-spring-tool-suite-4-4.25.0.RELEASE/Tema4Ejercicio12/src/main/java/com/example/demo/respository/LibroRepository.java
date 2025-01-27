package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Libro;

@Repository
public interface LibroRepository {
	
	void saveLibro(Libro libro);
	
	void refreshLibro(Libro libro);
	
	List<Libro> getLibros();
	 
	void refreshTitle(String titulo, int id);
}
