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
	public ResponseEntity<Vehiculo> postVehiculo(@RequestBody Vehiculo vehiculo){
		Vehiculo vehiculoDevuelto = service.postVehiculo(vehiculo);
		if(vehiculoDevuelto != null) {
			return ResponseEntity.ok(vehiculoDevuelto);
		}
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/actualizar/{is}")
	public ResponseEntity<Void> putVehiculo(@PathVariable Integer id, @RequestBody Vehiculo vehiculo){
		service.putVehiculo(id , vehiculo);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> deleteVehiculo(@PathVariable Integer id){
		service.deleteVehiculo(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/estado/{id}/{estado}")
	public ResponseEntity<Void> actualizarEstado(@PathVariable Integer id, @PathVariable String estado){
		service.actualizarEstado(id, estado);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/kilometraje/{id}/{km}")
	public ResponseEntity<Void> actualizarKilometraje(@PathVariable Integer id, @PathVariable Double km){
		service.actualizarKilometraje(id, km);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/estado/obtener/{estado}")
	public ResponseEntity<List<Vehiculo>> obtenerVehiculosEstado( @PathVariable String estado){
		List<Vehiculo> vehiculos = service.obtenerVehiculosEstado(estado);
		if(vehiculos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(vehiculos);
		}
	}
	
	@GetMapping("/año/{ini}/{fin}")
	public ResponseEntity<List<Vehiculo>> obtenerVehiculosAño(@PathVariable Integer ini, @PathVariable Integer fin){
		List<Vehiculo> vehiculos = service.obtenerVehiculosAño(ini, fin);
		if(vehiculos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(vehiculos);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
