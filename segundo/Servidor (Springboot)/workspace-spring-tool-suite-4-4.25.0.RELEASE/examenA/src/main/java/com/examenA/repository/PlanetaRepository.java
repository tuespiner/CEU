package com.examenA.repository;

import java.util.List;

import com.examenA.model.Luna;
import com.examenA.model.Planeta;

public interface PlanetaRepository {
	public List<Planeta> getPlanetas();
	public Planeta getPlanetaId(Long id);
	public Planeta savePlaneta(Planeta planeta);
	public void deletePlaneta(Long id);
}
