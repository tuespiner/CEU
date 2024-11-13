package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.service.VehiculoService;

@RestController
@RequestMapping("Vehiculo")
public class VehiculoController {
	@Autowired
	private VehiculoService service;
	
	@GetMapping("")
	public ResponseEntity<List<Vehiculo>> getVehiculos(){
		return ResponseEntity.ok(service.getVehiculos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vehiculo> getVehiculo(@PathVariable Integer id){
		Vehiculo vehiculo = service.getVehiculo(id);
		if( vehiculo == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(vehiculo);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Void> postVehiculo(@RequestBody Vehiculo vehiculo){
		service.postVehiculo(vehiculo);
		return ResponseEntity.noContent().build();
	}
	
}
