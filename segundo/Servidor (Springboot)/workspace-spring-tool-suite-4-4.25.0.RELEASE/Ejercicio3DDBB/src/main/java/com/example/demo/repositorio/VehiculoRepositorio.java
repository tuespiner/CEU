package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class VehiculoRepositorio {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Vehiculo> getVehiculos(){
		Query<Vehiculo> query = (Query<Vehiculo>) entityManager.
				createQuery("select v from Vehiculo v", Vehiculo.class);
		return query.getResultList();
	}
	
	public Vehiculo getVehiculo(Integer id) {
		return entityManager.find(Vehiculo.class, id);
	}
	
	@Transactional
	public Vehiculo postVehiculo(Vehiculo vehiculo) {
		entityManager.persist(vehiculo);
		return vehiculo;
	}
	
	@Transactional
	public void deleteVehiculo(Integer id) {
		Vehiculo vehiculo = getVehiculo(id);
		entityManager.remove(vehiculo);
	}
}
