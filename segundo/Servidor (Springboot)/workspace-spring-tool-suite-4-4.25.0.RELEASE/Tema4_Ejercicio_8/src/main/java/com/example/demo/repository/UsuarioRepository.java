package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class UsuarioRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Usuario> getUsuarios(){
		Query<Usuario> query = (Query<Usuario>) entityManager.createQuery("select u from Usuario u", Usuario.class);
		return query.getResultList();
	}
}
