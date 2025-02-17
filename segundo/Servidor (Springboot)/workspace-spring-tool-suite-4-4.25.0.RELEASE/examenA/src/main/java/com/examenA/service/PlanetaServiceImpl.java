package com.examenA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenA.model.Luna;
import com.examenA.model.Planeta;
import com.examenA.repository.PlanetaRepository;

import jakarta.transaction.Transactional;

@Service
public class PlanetaServiceImpl implements PlanetaService{

	@Autowired
	private PlanetaRepository repo;
	
	@Override
	@Transactional
	public Planeta crearPlaneta(Planeta planeta) {
		return repo.savePlaneta(planeta);
	}

	@Override
	public List<Planeta> listarTodos() {
		return repo.getPlanetas();
	}

	@Override
	@Transactional
	public void eliminarPlaneta(Long id) {
		//Y este si que no le encuentro el sentido, por que no funciona, no lo se, literalmente solo es 
		//manager.remove(planeta) pero no funciona
		repo.deletePlaneta(id);
	}

	@Override
	public List<Planeta> buscarPorTipo(String tipo) {
		List<Planeta> planetas = this.listarTodos();
		//planetas.stream().filter((planeta)-> planeta.getTipo().equalsIgnoreCase(tipo));
		List<Planeta> planetasTipo = new ArrayList<>();
		for(Planeta planeta : planetas){
			if(planeta.getTipo().equalsIgnoreCase(tipo)) {
				planetasTipo.add(planeta);
			}
		}
		System.out.println("tamano planetas gaseosos "+planetasTipo.size());
		return planetasTipo;
	}

	@Override
	@Transactional
	public Luna crearLuna(Luna luna, Long planetaId) {
		Planeta planeta = repo.getPlanetaId(planetaId);
		//He probado de todo aqui,poner el planeta en la luna y luego hacer el crearPlaneta
		//He probado a poner solo la luna en la lista del planeta y luego hacer el crearPlaneta
		//He probado a hacer las dos cosas juntas y nada me funciona, he mirado mi metodo y es que puede ocurrir
		luna.setPlaneta(planeta);
		planeta.getLunas().add(luna);
		this.crearPlaneta(planeta);
		return luna;
	}

	@Override
	public boolean existeJupiter() {
		Boolean esta = false;
		List<Planeta> planetas = this.listarTodos();
		planetas.stream().filter((planeta)-> planeta.getNombre().equalsIgnoreCase("jupiter"));
		if(planetas.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public Planeta getPlanetaId(Long id) {
		return repo.getPlanetaId(id);
	}

}
