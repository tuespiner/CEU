package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Empleado> getEmpleados() {
		return manager.createQuery("select e from Empleado e", Empleado.class).getResultList();
	}

	@Override
	public Empleado getEmpleadoId(Integer id) {
		return manager.find(Empleado.class, id);
	}

	@Override
	public void saveEmpleado(Empleado empleado) {
		if(empleado.getId() != null) {
			manager.merge(empleado);
		}else {
			manager.persist(empleado);
		}
	}

	@Override
	public void deleteEmpleado(Integer id) {
		manager.remove(id);
	}
	
}
