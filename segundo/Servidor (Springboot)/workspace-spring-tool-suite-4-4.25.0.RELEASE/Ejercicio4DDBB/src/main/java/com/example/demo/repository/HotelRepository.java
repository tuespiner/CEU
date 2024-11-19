package com.example.demo.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
public class HotelRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Hotel> getHoteles(){
		Query query = (Query) entityManager.createQuery("select h from Hotel h", Hotel.class);
		return query.getResultList();
	}
	
	@Transactional
	public void postHotel(Hotel hotel) {
		entityManager.persist(hotel);
	}
	
	@Transactional
	public Boolean deleteHotel(Integer id) {
		Hotel hotel = entityManager.find(Hotel.class, id);
		if(hotel != null) {
			entityManager.remove(hotel);
			return true;
		}
		return false;
	}
}
