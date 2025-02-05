package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Direccion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class DireccionRepositoryImpl implements DireccionRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Direccion> getDirecciones() {
		return manager.createQuery("select d from Direccion d", Direccion.class).getResultList();
	}

	@Override
	public Direccion getDireccion(int id) {
		return manager.find(Direccion.class, id);
	}

	@Override
	@Transactional
	public void saveDireccion(Direccion direccion) {
		if(this.getDireccion(direccion.getId())!= null) {
			manager.merge(direccion);
		}else {
			manager.persist(direccion);
		}
	}

	@Override
	@Transactional
	public void deleteDireccion(int id) {
		manager.remove(this.getDireccion(id));
	}

}
