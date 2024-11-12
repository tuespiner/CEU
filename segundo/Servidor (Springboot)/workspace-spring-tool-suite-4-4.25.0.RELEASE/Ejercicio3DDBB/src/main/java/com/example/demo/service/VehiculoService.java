package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.repositorio.VehiculoRepositorio;

@Service
public class VehiculoService {
	@Autowired
	private VehiculoRepositorio repo;
	
	public List<Vehiculo> getVehiculos(){
		return repo.getVehiculos();
	}
	
	public Vehiculo getVehiculo(Integer id) {
		return repo.getVehiculo(id);
	}
	
	public void postVehiculo(Vehiculo vehiculo) {
		repo.postVehiculo(vehiculo);
	}
}
