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
	public Empleado getEmpleado(int id) {
		return manager.find(Empleado.class, id);
	}

	@Override
	public void saveEmpleado(Empleado empleado) {
		if(this.getEmpleado(empleado.getId()) != null) {
			manager.merge(empleado);
		}else {
			manager.persist(empleado);
		}
	}

	@Override
	public void deleteEmpleado(int id) {
		if(this.getEmpleado(id) != null) {
			manager.remove(this.getEmpleado(id));
		}
	}

	@Override
	public List<Empleado> getEmpleadosPuesto(String puesto) {
		List<Empleado> empleados = this.getEmpleados();
		empleados.stream().filter((empleado) -> empleado.getPuesto().equalsIgnoreCase(puesto));
		return empleados;
	}
	
	
}
