package com.example.demo.serviece;

import org.springframework.stereotype.Service;

import com.example.demo.model.Libro;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface LibroService {
	
	void saveLibro(Libro libro);
	
}
