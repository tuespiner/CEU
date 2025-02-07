package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Direccion;
import com.example.demo.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService{

	@Autowired
	private DireccionRepository repo;
	
	@Override
	public List<Direccion> getDirecciones() {
		return repo.getDirecciones();
	}

	@Override
	public Direccion getDireccion(int id) {
		return repo.getDireccion(id);
	}

	@Override
	public void saveDireccion(Direccion direccion) {
		repo.saveDireccion(direccion);
	}

	@Override
	public void deleteDireccion(int id) {
		repo.deleteDireccion(id);
	}

	@Override
	public void actualizarCiudadPorNombreYLetra(String ciudad, String letra) {
		this.getDirecciones().stream().filter((direccion) -> direccion.getCiudad().startsWith(letra) || 
				direccion.getCiudad().startsWith(letra.toUpperCase())).forEach(((direccion) -> {
					direccion.setCiudad(ciudad);
					this.saveDireccion(direccion);
				}));
	}

	@Override
	public void actualizarCiudadASevilla() {
		this.actualizarCiudadPorNombreYLetra("Sevilla", "a");
	}

}
