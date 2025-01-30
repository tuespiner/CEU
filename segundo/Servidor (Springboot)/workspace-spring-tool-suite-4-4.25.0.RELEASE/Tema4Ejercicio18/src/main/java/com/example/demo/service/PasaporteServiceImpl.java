package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pasaporte;
import com.example.demo.repository.PasaporteRepository;

@Service
public class PasaporteServiceImpl implements PasaporteService{
	
	@Autowired 
	private PasaporteRepository repo;

	@Override
	public void savePasaporte(Pasaporte pasaporte) {
		repo.savePasaporte(pasaporte);
	}

	@Override
	public Pasaporte getPasaporte(int id) {
		return repo.getPasaporte(id);
	}
}
