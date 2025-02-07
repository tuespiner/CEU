package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Direccion;

@Repository
public interface DireccionRepository {
	public List<Direccion> getDirecciones();
	public Direccion getDireccion(int id);
	public void saveDireccion(Direccion direccion);
	public void deleteDireccion(int id);
	
}
