package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Libro;

@Repository
public interface LibroRepository {
	
	void saveLibro(Libro libro);
	 
	void refreshTitle(String titulo, int id);
}
