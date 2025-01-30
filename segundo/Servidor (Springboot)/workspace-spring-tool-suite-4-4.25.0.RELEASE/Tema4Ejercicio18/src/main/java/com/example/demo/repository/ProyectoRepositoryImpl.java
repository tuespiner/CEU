package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Proyecto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void saveProyecto(Proyecto proyecto) {
		if(this.getProyecto(proyecto.getId())!= null) {
			manager.merge(proyecto);
		}else {
			manager.persist(proyecto);
		}
	}

	@Override
	public Proyecto getProyecto(int id) {
		return manager.find(Proyecto.class, id);
	}
}
