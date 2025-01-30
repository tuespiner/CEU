package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Proyecto;

@Service
public interface ProyectoService {
	public void saveProyecto(Proyecto proyecto);
	public Proyecto getProyecto(int id);
}
