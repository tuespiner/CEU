package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Proyecto;

@Repository
public interface ProyectoRepository {
	public void saveProyecto(Proyecto proyecto);
	public Proyecto getProyecto(int id);
}
