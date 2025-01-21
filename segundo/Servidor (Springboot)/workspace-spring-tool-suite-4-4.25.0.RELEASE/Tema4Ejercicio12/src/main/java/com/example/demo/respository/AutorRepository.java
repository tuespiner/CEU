package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Autor;

@Repository
public interface AutorRepository{
	
	
	List<Autor> getAutores();
	
	Autor getAutor(int id);
	
	void saveAutor(Autor autor);
	
	void refreshAutor(Autor autor);
	
	void deleteAutor(int id);
	
	
}
