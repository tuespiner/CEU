package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Empleado;

public interface EmpleadoService {
	public List<Empleado> getEmpleados();
	public Empleado getEmpleadoId(Integer id);
	public void saveEmpleado(Empleado empleado);
	public void deleteEmpleado(Integer id);
	public List<Empleado> getEmpleadoPuesto(String puesto);
}
