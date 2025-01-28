package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PasaporteRepository;

@Service
public class PasaporteServiceImpl implements PasaporteService{
	
	@Autowired 
	private PasaporteRepository repo;
}
