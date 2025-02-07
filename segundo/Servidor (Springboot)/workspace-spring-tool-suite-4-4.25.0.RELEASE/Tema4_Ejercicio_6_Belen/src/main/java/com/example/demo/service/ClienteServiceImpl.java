package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repo;
	

	@Override
	public List<Cliente> getClientes() {
		return repo.getClientes();
	}

	@Override
	public Cliente getCliente(int id) {
		return repo.getCliente(id);
	}

	@Override
	public void saveCliente(Cliente cliente) {
		repo.saveCliente(cliente);
	}

	@Override
	public void deleteCliente(int id) {
		repo.deleteCliente(id);
	}

	@Override
	public void actualizarDireccion(Direccion direccion, int id) {
		Cliente cliente = this.getCliente(id);
		cliente.setDireccion(direccion);
		this.saveCliente(cliente);
	}

	@Override
	public List<Cliente> getClientesCiudad(String ciudad) {
		List<Cliente> clientes = this.getClientes();
		clientes.stream().filter((cliente) -> cliente.getDireccion().getCiudad().equals(ciudad));
		return clientes;
	}

}
