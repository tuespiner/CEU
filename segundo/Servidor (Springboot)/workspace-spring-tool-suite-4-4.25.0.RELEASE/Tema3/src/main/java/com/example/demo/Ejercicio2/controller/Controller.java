package com.example.demo.Ejercicio2.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Ejercicio2.modelo.Cliente;
@RestController
@RequestMapping("/clientes")
public class Controller {
	private List<Cliente> clientes;
	
	public Controller(){
		this.clientes= new ArrayList<Cliente>();
		Cliente c1 = new Cliente("1", "juan", "tumama", "1234");
		Cliente c2 = new Cliente("2", "juan", "si", "1234");
		Cliente c3 = new Cliente("3", "juan", "juanito", "1234");
		Cliente c4 = new Cliente("4", "juan", "tuespiner", "1234");
		this.clientes.add(c1);
		this.clientes.add(c2);
		this.clientes.add(c3);
		this.clientes.add(c4);
	}
	
	@GetMapping
	public List<Cliente> devolverClientes(){
		return this.clientes;
	}
	
	@GetMapping("/{username}")
	public Cliente devolverCliente(@PathVariable String username) {
		Cliente cliente = null;
		for(Cliente cli : this.clientes) {
			if(cli.getUsername().equals(username)) {
				cliente = cli;
			}
		}
		return cliente;
	}
	
	@PostMapping("")
	public Cliente publicarCliente(@RequestBody Cliente cliente) {
		this.clientes.add(cliente);
		return cliente;
	}
	
	@PutMapping("")
	public Cliente modificarCliente(@RequestBody Cliente cliente) {
		for(Cliente cliente2 : this.clientes) {
			if(cliente2.getId().equals(cliente.getId())) {
				cliente2.setNombre(cliente.getNombre());
				cliente2.setPassword(cliente.getPassword());
				cliente2.setUsername(cliente.getUsername());
			}
		}
		return cliente;
	}
	
	@DeleteMapping("/{id}")
	public List<Cliente> eliminarCliente(@PathVariable String id) {
		int i = 0;
		Iterator<Cliente> it = clientes.iterator();
		while(it.hasNext()) {
			Cliente cliente = it.next();
			if(cliente.getId().equals(id)) {
				it.remove();
			}
		}
		return this.clientes;
	}
	
	@PatchMapping("")
	public Cliente modificarUnDato(@RequestBody Cliente cliente) {
		for(Cliente cli : this.clientes) {
			if(cli.getId().equals(cliente.getId())) {
				if(cliente.getNombre() != null) {
					cli.setNombre(cliente.getNombre());
				}
				if(cliente.getPassword()!= null){
					cli.setPassword(cliente.getPassword());
				}
				if(cliente.getUsername() != null) {
					cli.setUsername(cliente.getUsername());
				}
				return cli;
			}
		}
		return null;
	}
	
	@PatchMapping("/{id}")
	public Cliente modificarUnDato(@RequestBody Cliente cliente, @PathVariable String id) {
		for(Cliente cli : this.clientes) {
			if(cli.getId().equals(id)) {
				if(cliente.getNombre() != null) {
					cli.setNombre(cliente.getNombre());
				}
				if(cliente.getPassword()!= null){
					cli.setPassword(cliente.getPassword());
				}
				if(cliente.getUsername() != null) {
					cli.setUsername(cliente.getUsername());
				}
				return cli;
			}
		}
		return null;
	}
	
	
}
