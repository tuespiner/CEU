package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Pasaporte;

@Repository
public interface PasaporteRepository {
	public void savePasaporte(Pasaporte pasaporte);
	public Pasaporte getPasaporte(int id);
}
