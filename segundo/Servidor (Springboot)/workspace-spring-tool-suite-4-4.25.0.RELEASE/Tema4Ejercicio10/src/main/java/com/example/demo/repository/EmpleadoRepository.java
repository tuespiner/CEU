package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Empleado;

public interface EmpleadoRepository {
	
	public List<Empleado> getEmpleados();
	public Empleado getEmpleado(int id);
	public void saveEmpleado(Empleado empleado);
	public void deleteEmpleado(int id);
	public List<Empleado> getEmpleadosPuesto(String puesto);
}
