package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Proyecto;
import com.example.demo.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private ProyectoRepository repo;

	@Override
	public void saveProyecto(Proyecto proyecto) {
		repo.saveProyecto(proyecto);
	}

	@Override
	public Proyecto getProyecto(int id) {
		return repo.getProyecto(id);
	}
}
