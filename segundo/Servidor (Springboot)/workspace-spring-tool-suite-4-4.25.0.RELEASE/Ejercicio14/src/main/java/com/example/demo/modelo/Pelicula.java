package com.example.demo.modelo;

import java.time.LocalDate;
import java.util.List;

public class Pelicula {
	private Integer id;
	private String titulo;
	private String director;
	private LocalDate fechaDeLanzamiento;
	private Integer duracion;
	private List<Actor> Actores;
	
	public Pelicula(Integer id, String titulo, String director, LocalDate fechaDeLanzamiento, Integer duracion, List<Actor> Actores) {
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.fechaDeLanzamiento = fechaDeLanzamiento;
		this.duracion = duracion;
		this.Actores = Actores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public LocalDate getFechaDeLanzamiento() {
		return fechaDeLanzamiento;
	}

	public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
		this.fechaDeLanzamiento = fechaDeLanzamiento;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public List<Actor> getActores() {
		return Actores;
	}

	public void setActores(List<Actor> actores) {
		Actores = actores;
	}
	
	
}
