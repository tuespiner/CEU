package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

@Repository
public interface ClienteRepository {
	public List<Cliente> getClientes();
	public Cliente getCliente(int id);
	public void saveCliente(Cliente cliente);
	public void deleteCliente(int id);
}
