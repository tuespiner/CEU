package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repositorio.ClienteRepositorio;
import com.example.demo.repositorio.ClienteRepositorioImpl;

import jakarta.transaction.Transactional;

@Service

public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteRepositorio repo;
	
	public List<Cliente> getClientes(){
		return repo.getClientes();
	}
	
	public Cliente getCliente(Integer id) {
		return repo.getCliente(id);
	}
	
	public void postCliente(Cliente cliente) {
		repo.postCliente(cliente);
	}
	
	public void deleteCliente(Integer id) {
		repo.deleteCliente(id);
	}
	public Cliente getClienteNombre(String nombre) {
		return repo.getClienteNombre(nombre);
	}
	public Boolean putCliente(Integer id, Cliente cliente) {
		return repo.putCliente(id, cliente);
	}
	public Boolean patchCliente(Integer id, Cliente cliente) {
		return repo.patchCliente(id, cliente);
	}
}
