package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface ClienteRepositorio {
	
	List<Cliente> getClientes();
	
	Cliente getCliente(Integer id);
	
	void postCliente(Cliente cliente);
	
	void deleteCliente(Integer id);
	
	Cliente getClienteNombre(String nombre);
	
	Boolean putCliente(Integer id, Cliente cliente);
	
	Boolean patchCliente(Integer id, Cliente cliente);
}
