package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ClienteRepositorio {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Cliente> getClientes(){
		Query<Cliente> query = (Query<Cliente>) entityManager.
				createQuery("select c from Cliente c", Cliente.class);
		return query.getResultList();
	}
	
	public Cliente getCliente(Integer id) {	
		Cliente cliente =  entityManager.find(Cliente.class, id);
		return cliente;
	}
	
	@Transactional
	public void postCliente(Cliente cliente) {
		entityManager.persist(cliente);
	}
	
	@Transactional
	public void deleteCliente(Integer id) {
		entityManager.remove(getCliente(id));
	}
}
