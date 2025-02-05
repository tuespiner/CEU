package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Direccion;

@Service
public interface ClienteService {
	public List<Cliente> getClientes();
	public Cliente getCliente(int id);
	public void saveCliente(Cliente cliente);
	public void deleteCliente(int id);
	public void actualizarDireccion(Direccion direccion, int id);
	public List<Cliente> getClientesCiudad(String ciudad);
}
