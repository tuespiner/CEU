package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Pasaporte;

@Service
public interface PasaporteService {
	public void savePasaporte(Pasaporte pasaporte);
	public Pasaporte getPasaporte(int id);
}
