package com.example.demo.model;

import java.util.List;

public class Libro {
	private String titulo;
	private Integer id;
	private String autor;
	private String editorial;
	private String isbn;
	private Integer añoPublicacion;
	private List<String> generos;
	
	public Libro(String titulo, int id, String autor, String editorial, String isbn, Integer añoPublicacion, List<String> generos) {
		this.titulo = titulo;
		this.id = id;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.añoPublicacion = añoPublicacion;
		this.generos = generos;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getAñoPublicacion() {
		return añoPublicacion;
	}
	public void setAñoPublicacion(Integer añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}
	public List<String> getGeneros() {
		return generos;
	}
	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	
	
}
