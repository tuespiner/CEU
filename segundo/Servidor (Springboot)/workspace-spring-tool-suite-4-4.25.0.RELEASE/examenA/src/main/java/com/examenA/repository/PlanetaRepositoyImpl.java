package com.examenA.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.examenA.model.Planeta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PlanetaRepositoyImpl implements PlanetaRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Planeta> getPlanetas() {
		return manager.createQuery("select p from Planeta p", Planeta.class).getResultList();
	}

	@Override
	public Planeta getPlanetaId(Long id) {
		return manager.find(Planeta.class, id);
	}

	@Override
	public Planeta savePlaneta(Planeta planeta) {
		if(planeta.getId() == null) {
			manager.persist(planeta);
			return planeta;
		}else {
			manager.merge(planeta);
			return planeta;
		}
	}

	@Override
	public void deletePlaneta(Long id) {
		if(this.getPlanetaId(id) != null) {
			manager.remove(id);
		}
	}

}
