package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("Cliente")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> getClientes(){
		return ResponseEntity.ok(service.getClientes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Integer id){
		return ResponseEntity.ok(service.getCliente(id));
	}
	
	@PostMapping("/añadir")
	public ResponseEntity<Void> postCliente(@RequestBody Cliente cliente){
		service.postCliente(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Integer id){
		service.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/modif/put/{id}")
	public ResponseEntity<Void> putCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
		if(service.putCliente(id, cliente) == false) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/modif/patch/{id}")
		public ResponseEntity<Void> patchCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
			Boolean bolean = service.patchCliente(id, cliente);
			if(bolean == false) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.noContent().build();
		}
	
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Cliente> getClienteNombre(@PathVariable String nombre){
		Cliente cliente = service.getClienteNombre(nombre);
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
}
