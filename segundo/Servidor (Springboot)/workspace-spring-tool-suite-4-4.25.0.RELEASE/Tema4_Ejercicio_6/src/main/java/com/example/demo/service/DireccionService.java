package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Direccion;

@Service
public interface DireccionService {
	public List<Direccion> getDirecciones();
	public Direccion getDireccion(int id);
	public void saveDireccion(Direccion direccion);
	public void deleteDireccion(int id);
	public void actualizarCiudadPorNombreYLetra(String ciudad, String letra);
	public void actualizarCiudadASevilla();
}
