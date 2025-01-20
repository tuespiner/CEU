package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Autor;

@Repository
public interface AutorRepository{
	
	
	List<Autor> getAutores();
	
}
