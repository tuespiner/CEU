package com.example.demo.aplicacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

import com.example.demo.Ejercicio9Application;
import com.example.demo.modelo.Alumnos;
//@SpringBootApplication
import com.example.demo.modelo.Direccion;

@RestController
@RequestMapping("/alumnos")
public class App2 {
	
	private List<Alumnos> alumnos; 
/*	
	public static void main(String[] args) {
		SpringApplication.run(Ejercicio9Application.class, args);
	}*/
	
	public App2() {
		this.alumnos = new ArrayList<Alumnos>();
		Direccion direccion1 = new Direccion("calle 1", 1, "sevilla");
		Alumnos alumno1 = new Alumnos("1","juan","juanspiner89@gmail.com",19,direccion1);
		Direccion direccion2 = new Direccion("calle 2", 1, "sevilla");
		Alumnos alumno2 = new Alumnos("2","juan","juanspiner89@gmail.com",19,direccion2);
		Direccion direccion3 = new Direccion("calle 3", 2, "madrid");
		Alumnos alumno3 = new Alumnos("3","juan","juanspiner89@gmail.com",19,direccion3);
		Direccion direccion4 = new Direccion("calle 1", 3, "cordoba");
		Alumnos alumno4 = new Alumnos("4","juan","juanspiner89@gmail.com",19,direccion4);
		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		alumnos.add(alumno4);
	}
	@GetMapping
	public ResponseEntity<List<Alumnos>> getAlumnos(){
		return ResponseEntity.ok(alumnos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumnos> getAlumno(@PathVariable String id){
		for(Alumnos alumno : this.alumnos) {
			if(alumno.getId().equals(id)) {
				return ResponseEntity.ok(alumno);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Alumnos> setAlumno(@RequestBody Alumnos add) {
		Alumnos aluNuevo = new Alumnos(add.getId(),add.getNombre(),add.getEmail(),add.getEdad(),add.getDireccion());
		this.alumnos.add(aluNuevo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Alumnos> modifEntireAlumno(@RequestBody Alumnos modif) {
		for(Alumnos alumno : alumnos) {
			if(alumno.getId().equals(modif.getId())) {
				alumno = modif;
				return ResponseEntity.noContent().build();
			}
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Alumnos> delAlumno(@RequestBody Alumnos modif) {
		Iterator<Alumnos> it = alumnos.iterator();
		while(it.hasNext()) {
			Alumnos alumno = it.next();
			if(alumno.getId().equals(modif.getId())) {
				it.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{id}")
	public Alumnos modifElementAlumno(@RequestBody Alumnos modif, @PathVariable String id) {
		for(Alumnos alumno : alumnos) {
			if(alumno.getId().equals(id)) {
				if(modif.getNombre()!=null) {
					alumno.setNombre(modif.getNombre());				
				}
				if(modif.getEmail() != null) {
					alumno.setEmail(modif.getEmail());
				}
				if(modif.getEdad() != 0) {
					alumno.setEdad(modif.getEdad());
				}
				return alumno;
			}
		}
		return null;
	}
	
	@GetMapping("/direcciones")
	public ResponseEntity<List<Direccion>> getDirecciones(){
		List<Direccion> direcciones = new ArrayList<>();
		for(Alumnos alumno : alumnos) {
			direcciones.add(alumno.getDireccion());
		}
		return ResponseEntity.ok(direcciones);
	}
	
	@GetMapping("/direcciones/codigoPostal/{codigoPostal}")
	public ResponseEntity<List<Direccion>> getDireccionesPorCodigoPostal(@PathVariable Integer codigoPostal){
		List<Direccion> direccionPorCodigoPostal = new ArrayList<>();
		for(Alumnos alumno : alumnos) {
			if( alumno.getDireccion().getCodigoPostal() == codigoPostal) {
				direccionPorCodigoPostal.add(alumno.getDireccion());
			}
		}
		if(direccionPorCodigoPostal.size()!=0) {
			return ResponseEntity.ok(direccionPorCodigoPostal);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/direcciones/ciudad/{ciudad}")
	public ResponseEntity<Integer> contarAlumnosPorCiudad(@PathVariable String ciudad){
		Integer contador = 0;
		for(Alumnos alumno : alumnos) {
			if(alumno.getDireccion().getCiudad().equals(ciudad)) {
				contador++;
			}
		}
		return ResponseEntity.ok(contador);
	}

}
