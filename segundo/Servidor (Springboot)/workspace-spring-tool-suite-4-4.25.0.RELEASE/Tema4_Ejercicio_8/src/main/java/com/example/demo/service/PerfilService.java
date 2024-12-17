package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	private PerfilRepository perfil;
}
