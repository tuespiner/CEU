package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Producto;
import com.example.demo.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Producto> getProductos(){
		Query<Producto> query = (Query<Producto>) entityManager.createQuery("select v from Producto v", Producto.class);
		return query.getResultList();
	}
	
	public Producto getProducto(Integer id) {
		return entityManager.find(Producto.class, id);
	}
}
