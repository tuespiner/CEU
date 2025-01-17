package com.example.demo.serviece;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Autor;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface AutorService {
	
	List<Autor> getAutores();
}
