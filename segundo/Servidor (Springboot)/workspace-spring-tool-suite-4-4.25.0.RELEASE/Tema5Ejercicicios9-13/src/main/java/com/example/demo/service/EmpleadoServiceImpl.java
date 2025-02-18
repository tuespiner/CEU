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
	public Empleado getEmpleadoId(Integer id) {
		return repo.getEmpleadoId(id);
	}

	@Override
	public void saveEmpleado(Empleado empleado) {
		repo.saveEmpleado(empleado);
	}

	@Override
	public void deleteEmpleado(Integer id) {
		repo.deleteEmpleado(id);
	}

	@Override
	public List<Empleado> getEmpleadosPuesto(String puesto) {
		List<Empleado> empleadosPuesto = this.getEmpleados();
		empleadosPuesto.stream().filter((empleado)->empleado.getPuesto().equalsIgnoreCase(puesto));
		return empleadosPuesto;
	}

}
