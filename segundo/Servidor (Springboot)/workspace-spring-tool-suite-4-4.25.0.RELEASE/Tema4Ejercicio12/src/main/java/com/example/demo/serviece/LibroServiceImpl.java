package com.example.demo.serviece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Libro;
import com.example.demo.respository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroRepository repo;

	@Override
	public void saveLibro(Libro libro) {
		repo.saveLibro(libro);
	}

}
