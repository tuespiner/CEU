package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Pasaporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PasaporteRepositoryImpl implements PasaporteRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void savePasaporte(Pasaporte pasaporte) {
		if(this.getPasaporte(pasaporte.getId()) != null) {
			manager.merge(pasaporte);
		}else {
			manager.persist(pasaporte);
		}
	}

	@Override
	public Pasaporte getPasaporte(int id) {
		return manager.find(Pasaporte.class, id);
	}
}
