package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Autor;
import com.example.demo.model.Libro;

@Repository
public interface AutorRepository{
	
	
	List<Autor> getAutores();
	
	Autor getAutor(int id);
	
	void saveAutor(Autor autor);
	
	void refreshAutor(Autor autor);
	
	void deleteAutor(int id);
	
<<<<<<< HEAD
	void insertLibro(Libro libro, int id);
	
	void deleteLibroAutor(Libro libro);
	
	List<Libro> getLibros();
	
=======
>>>>>>> be0434bc7a2f9f070aaca12adafbb01e273dc247
	
}
