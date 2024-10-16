package com.example.demo.app;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.example.demo.modelo.Actor;
import com.example.demo.modelo.Pelicula;

@RestController
@RequestMapping("/Pelicula")
public class App {
	private List<Pelicula> peliculas;
	
	public App() {
		this.peliculas = new ArrayList<>();
		List<Actor> actores = new ArrayList<>();
		Actor actor1 = new Actor(1, "nombre1", "Española");
		Actor actor2 = new Actor(2, "nombre2", "Española");
		Actor actor3 = new Actor(3, "nombre3", "Inglesa");
		Actor actor4 = new Actor(4, "nombre4", "Española");
		Actor actor5 = new Actor(5, "nombre5", "Mexicana");
		actores.add(actor1);
		actores.add(actor2);
		Pelicula pelicula1 = new Pelicula(1, "titulo1", "director1", LocalDate.of(2010, 4, 1), 120, actores);
		actores = new ArrayList<>();
		actores.add(actor1);
		actores.add(actor3);
		Pelicula pelicula2 = new Pelicula(2,"titulo2", "director1", LocalDate.of(2015, 4, 1), 130, actores);
		actores = new ArrayList<>();
		actores.add(actor4);
		actores.add(actor5);
		Pelicula pelicula3 = new Pelicula(3,"titulo3", "director2", LocalDate.of(2000, 9, 1), 100, actores);
		actores = new ArrayList<>();
		actores.add(actor5);
		actores.add(actor1);
		Pelicula pelicula4 = new Pelicula(4,"titulo4", "director3", LocalDate.of(2020, 4, 10),220, actores);
		this.peliculas.add(pelicula1);
		this.peliculas.add(pelicula2);
		this.peliculas.add(pelicula3);
		this.peliculas.add(pelicula4);
	}
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> getPeliculas(){
		return ResponseEntity.ok(peliculas);
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<Pelicula> getPelicula(@PathVariable String titulo) {
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getTitulo().equals(titulo)) {
				return ResponseEntity.ok(pelicula);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> postPelicula( @RequestBody Pelicula pelicula){
		peliculas.add(pelicula);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> setPeliculaEntera(@RequestBody Pelicula pel){
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getId() == pel.getId()) {
				pelicula.setActores(pel.getActores());
				pelicula.setDirector(pel.getDirector());
				pelicula.setDuracion(pel.getDuracion());
				pelicula.setFechaDeLanzamiento(pel.getFechaDeLanzamiento());
				pelicula.setTitulo(pel.getTitulo());
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> setPelicula(@RequestBody Pelicula pel, @PathVariable Integer id){
		Boolean encontrada = false;
		for(Pelicula pelicula: peliculas) {
			if(pelicula.getId() == id) {
				if(pel.getActores() != null) {
					pelicula.setActores(pel.getActores());
				}
				if(pel.getDirector()!= null) {
					pelicula.setDirector(pel.getDirector());
				}
				if(pel.getDuracion() != 0 || pel.getDuracion()!= null) {
					pelicula.setDuracion(pel.getDuracion());
				}
				if(pel.getFechaDeLanzamiento()!= null) {
					pelicula.setFechaDeLanzamiento(pel.getFechaDeLanzamiento());
				}
				if(pel.getTitulo() != null) {
					pelicula.setTitulo(pel.getTitulo());
				}
				encontrada = true;
			}
			
		}
		if(encontrada) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePelicula(@PathVariable Integer id){
		Iterator it = peliculas.iterator();
		while(it.hasNext()) {
			Pelicula pelicula = (Pelicula) it.next();
			if(pelicula.getId() == id) {
				it.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/director/{director}")
	public ResponseEntity<List<Pelicula>> getPeliculasDirector(@PathVariable String director){
		List<Pelicula> peliculasDirector = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getDirector().equals(director)) {
				peliculasDirector.add(pelicula);
			}
		}
		return ResponseEntity.ok(peliculasDirector);
	}
	
	@GetMapping("/años")
	public ResponseEntity<List<Pelicula>> getPeliculasAño(){
		List<Pelicula> peliculasAños = new ArrayList<>();
		LocalDate fecha = LocalDate.now();
		for(Pelicula pelicula : peliculas ) {
			Period p = pelicula.getFechaDeLanzamiento().until(fecha);
			if(p.getYears() <=5) {
				peliculasAños.add(pelicula);
			}
		}
		return ResponseEntity.ok(peliculasAños);
	}
	
	@GetMapping("/duracion")
	public ResponseEntity<Pelicula> getPeliculaDuracion(){
		int i = 0;
		Pelicula pelicula = null;
		for(Pelicula pel : peliculas) {
			if(pel.getDuracion() >= i) {
				pelicula = pel;
			}
		}
		return ResponseEntity.ok(pelicula);
	}
	
	@GetMapping("/actor/{nombreActor}")
	public ResponseEntity<List<Pelicula>> getPeliculasActor(@PathVariable String nombreActor){
		List<Pelicula> peliculasActor = new ArrayList<>();
		Boolean encontro = false;
		for(Pelicula pelicula : peliculas) {
			for(Actor actor : pelicula.getActores()) {
				if(actor.getNombre().equals(nombreActor)) {
					peliculasActor.add(pelicula);
					encontro = true;
				}
			}
		}
		if(encontro) {
			return ResponseEntity.ok(peliculasActor);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/nacionalidad/{nacionalidad}")
	public ResponseEntity<List<Actor>> getActorNacionalidad(@PathVariable String nacionalidad){
		Boolean encontro = false;
		List<Actor> actores = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			for(Actor actor : pelicula.getActores()) {
				if(actor.getNacionalidad().equals(nacionalidad)) {
					actores.add(actor);
					encontro = true;
				}
			}
		}
		if(encontro) {
			return ResponseEntity.ok(actores);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/actores")
	public ResponseEntity<Set<Actor>> getActorNoRepeat(){
		Set<Actor> actores = new HashSet();
		for(Pelicula pelicula : peliculas) {
			for(Actor actor : pelicula.getActores()) {
				actores.add(actor);
			}
		}
		if(actores.size() > 0) {
			return ResponseEntity.ok(actores);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/director/cant/{cantPelicula}")
	public ResponseEntity<Map<String, Integer>> getDirectoresNPeliculas(@PathVariable Integer cantPelicula){
		Map<String, Integer> directores = new HashMap<>();
		Map<String, Integer> directoresCant = new HashMap<>();
		for(Pelicula pelicula : peliculas) {
			if(directores.containsKey(pelicula.getDirector())) {
				directores.put(pelicula.getDirector(), directores.get(pelicula.getDirector()) + 1);
			}else {
				directores.put(pelicula.getDirector(), 1);
			}
		}
		for(String key : directores.keySet()) {
			Integer i = directores.get(key);
			if(i >= cantPelicula) {
				directoresCant.put(key, i);
			}
		}
		return ResponseEntity.ok(directoresCant);
	}
	
	}
