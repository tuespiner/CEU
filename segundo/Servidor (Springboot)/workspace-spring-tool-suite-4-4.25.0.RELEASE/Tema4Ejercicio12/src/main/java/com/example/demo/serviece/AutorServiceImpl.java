package com.example.demo.serviece;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Autor;
import com.example.demo.respository.AutorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutorServiceImpl implements AutorService{
	
	@Autowired
	private AutorRepository repo;
	
	public List<Autor> getAutores(){
		return repo.getAutores();
	}
}
