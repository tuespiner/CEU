package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Empleado;

public interface EmpleadoRepository {
	public List<Empleado> getEmpleados();
	public Empleado getEmpleadoId(Integer id);
	public void saveEmpleado(Empleado empleado);
	public void deleteEmpleado(Integer id);
}
