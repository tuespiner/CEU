package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Oficina;

public interface OficinaRepository {
	public List<Oficina> getOficinas();
	public Oficina getOficina(int id);
	
}
