package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository repo;
	
	@Override
	public List<Empleado> getEmpleados() {
		return repo.getEmpleados();
	}

	@Override
	public Empleado getEmpleado(int id) {
		return repo.getEmpleado(id);
	}

	@Override
	
	public void saveEmpleado(Empleado empleado) {
		repo.saveEmpleado(empleado);
	}
	
}
