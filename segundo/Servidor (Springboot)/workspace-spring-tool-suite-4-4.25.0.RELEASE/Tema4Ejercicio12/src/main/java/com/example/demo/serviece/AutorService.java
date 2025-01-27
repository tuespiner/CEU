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
	
<<<<<<< HEAD
=======
	Autor getAutor(int id);
	
>>>>>>> be0434bc7a2f9f070aaca12adafbb01e273dc247
	void saveAutor(Autor autor);
	
	void refreshAutor(Autor autor);
	
	void deleteAutor(int id);
	
<<<<<<< HEAD
	void insertLibro(Libro libro, int id);
	
	void deleteLibroAutor(Libro libro);
	
	List<Libro> getLibros();
=======
	void addLibroAutor(Libro libro, int id);
	
	void deleteLibroAutor(int id, int libro);
	
	List<Libro> getLibrosAutor(int id);
>>>>>>> be0434bc7a2f9f070aaca12adafbb01e273dc247
}
