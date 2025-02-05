package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
	private String nombre;
	private List<Libro> libros;
	
	public Autor() {
		this.libros = new ArrayList<Libro>();
	}
	
	public Autor(String nombre, List<Libro> libros) {
		this.nombre = nombre;
		this.libros = libros;
	}
}
