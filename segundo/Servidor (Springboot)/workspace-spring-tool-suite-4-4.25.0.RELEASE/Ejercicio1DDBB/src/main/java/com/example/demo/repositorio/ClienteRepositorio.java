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
	
	public Cliente getClienteNombre(String nombre) {
		List<Cliente> lista = getClientes();
		for(Cliente cli : lista){
			if(cli.getNombre().equals(nombre)) {
				return cli;
			}
		}
		return null;
	}
	
	@Transactional
	public Boolean putCliente(Integer id, Cliente cliente) {
		cliente.setId(id);
		if(entityManager.find(Cliente.class, id) != null) {
			entityManager.merge(cliente);
			return true;
		}else {
			return false;
		}
		
	}
	@Transactional
	public Boolean patchCliente(Integer id, Cliente cliente) {
		Cliente cambiar = entityManager.find(Cliente.class, id);
		if(cambiar != null) {
			if(cliente.getApellidos() != null) {
				cambiar.setApellidos(cliente.getApellidos());
			}
			if(cliente.getNombre() != null) {
				cambiar.setNombre(cliente.getNombre());
			}
			entityManager.merge(cambiar);
			return true;
		}else {
			return false;
		}
	}
}
