package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PerfilRepository {
	@PersistenceContext
	private EntityManager manager;
}
