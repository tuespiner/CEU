package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<Cliente> getClientes() {
		return manager.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	@Override
	public Cliente getCliente(int id) {
		return manager.find(Cliente.class, id);
	}

	@Override
	@Transactional
	public void saveCliente(Cliente cliente) {
		System.out.println(cliente.getId());
		if(this.getCliente(cliente.getId())!= null) {
			manager.merge(cliente);
		}else {
			manager.persist(cliente);
		}
	}

	@Override
	@Transactional
	public void deleteCliente(int id) {
		manager.remove(this.getCliente(id));
	}

}
