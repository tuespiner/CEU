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
	
	public Vehiculo postVehiculo(Vehiculo vehiculo) {
		return repo.postVehiculo(vehiculo);
	}
	
	public void putVehiculo(Integer id, Vehiculo vehiculo) {
		repo.putVehiculo(id, vehiculo);
	}
	
	public void deleteVehiculo(Integer id) {
		repo.deleteVehiculo(id);
	}
	
	public void actualizarEstado(Integer id, String estado) {
		repo.actualizarEstado(id, estado);
	}
	
	public void actualizarKilometraje(Integer id, Double km) {
		repo.actualizarKilometraje(id, km);
	}
	
	public List<Vehiculo> obtenerVehiculosEstado(String estado){
		return repo.obtenerVehiculosEstado(estado);
	}
	
	public List<Vehiculo> obtenerVehiculosAño(Integer ini, Integer fin){
		return repo.obtenerVehiculosAño(ini, fin);
	}
}
