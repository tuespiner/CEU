package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Empleado;

public interface EmpleadoService {
	public List<Empleado> getEmpleados();
	public Empleado getEmpleado(int id);
	public void saveEmpleado(Empleado empleado);
}
