package com.example.demo.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.example.demo.model.Tarea;

@RestController
@RequestMapping("/Tareas")
public class app {
	private List<Tarea> tareas;
	public app() { 
		Tarea tarea1 = new Tarea(1, "tarea1", "programar pagina 1", LocalDate.of(2024, 10, 30), "pendiente");
		Tarea tarea2 = new Tarea(2, "tarea2", "Limpiar baño", LocalDate.of(2024, 10, 22), "pendiente");
		Tarea tarea3 = new Tarea(3, "tarea3", "diseñar pagina 1", LocalDate.of(2024, 10, 23), "completa");
		Tarea tarea4 = new Tarea(4, "tarea4", "programar pagina 2", LocalDate.of(2024, 10, 22), "en_proceso");
		List<Tarea> tareas = new ArrayList<>();
		tareas.add(tarea1);
		tareas.add(tarea2);
		tareas.add(tarea3);
		tareas.add(tarea4);
		this.tareas = tareas;
	}
	
	@GetMapping
	public ResponseEntity<List<Tarea>> getTareas(){
		if(this.tareas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(this.tareas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarea> getTarea(@PathVariable Integer id){
		for(Tarea tarea : this.tareas) {
			if(tarea.getId() == id) {
				return ResponseEntity.ok(tarea);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> postTarea(@RequestBody Tarea tarea){
		this.tareas.add(tarea);
		return	ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> putTarea(@RequestBody Tarea tarea, @PathVariable Integer id){
		int i = 0;
		for(Tarea quest : this.tareas) {
			if(quest.getId() == id) {
				quest.setDescripcion(tarea.getDescripcion());
				quest.setEstado(tarea.getEstado());
				quest.setFechaVencimiento(tarea.getFechaVencimiento());
				quest.setTitulo(tarea.getTitulo());
				return ResponseEntity.noContent().build();
			}
			i++;
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> patchTarea(@PathVariable Integer id, @RequestBody Tarea tarea){
		for(Tarea quest: this.tareas){
			if(quest.getId() == id) {
				if(tarea.getDescripcion() != null) {
					quest.setDescripcion(tarea.getDescripcion());
				}
				if(tarea.getEstado() != null) {
					quest.setEstado(tarea.getEstado());
				}
				if(tarea.getFechaVencimiento()!= null) {
					quest.setFechaVencimiento(tarea.getFechaVencimiento());
				}
				if(tarea.getTitulo() != null){
					quest.setTitulo(tarea.getTitulo());
				}
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTarea(@PathVariable Integer id){
		Iterator it = this.tareas.iterator();
		while(it.hasNext()) {
			Tarea tarea = (Tarea) it.next();
			if(tarea.getId() == id) {
				it.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<Tarea>> getTareasEstado(@PathVariable String estado){
		List<Tarea> estados = new ArrayList<>();
		for(Tarea tarea : this.tareas) {
			if(tarea.getEstado().equals(estado)) {
				estados.add(tarea);
			}
		}
		if(estados.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estados);
	}
	
	@GetMapping("/proximas/{dias}")
	public ResponseEntity<List<Tarea>> getTareasVencimiento(@PathVariable Integer dias){
		List<Tarea> tareasVencimiento = new ArrayList<>();
		for(Tarea tarea : this.tareas) {
			if(((LocalDate.now()).plusDays(dias).isAfter(tarea.getFechaVencimiento())) 
					&&
					((LocalDate.now()).isBefore(tarea.getFechaVencimiento()))) {
				tareasVencimiento.add(tarea);
			}
		}
		if(tareasVencimiento.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tareasVencimiento);
		
	}
	
	@GetMapping("/contar-estado")
	public ResponseEntity<Map<String,Integer>> getEstadoContar(){
		Map<String, Integer> mapaEstado = new HashMap<>();
		for(Tarea tarea : this.tareas) {
			if(mapaEstado.isEmpty() || !mapaEstado.containsKey(tarea.getEstado())) {
				mapaEstado.put(tarea.getEstado(), 1);
			}else {
				mapaEstado.put(tarea.getEstado(), mapaEstado.get(tarea.getEstado()) +1);
			}
		}
		return ResponseEntity.ok(mapaEstado);
	}
	
	@GetMapping("/buscar/{clave}")
	public ResponseEntity<List<Tarea>> getPalabraClave(@PathVariable String clave){
		List<Tarea> tareasClave = new ArrayList<>();
		for(Tarea tarea : this.tareas) {
			if(tarea.getDescripcion().toUpperCase().contains(clave.toUpperCase())) {
				tareasClave.add(tarea);
			}
		}
		if(tareasClave.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(tareasClave);
	}
	
	@PatchMapping("/marcar-completadas")
	public ResponseEntity<Void> patchCompletadas(){
		for(Tarea tarea : this.tareas) {
			if((LocalDate.now()).isAfter(tarea.getFechaVencimiento())) {
				tarea.setEstado("completada");
			}
		}
		return ResponseEntity.noContent().build();
	}
}
