package com.example.demo.Modelo;

import java.util.List;

public class Album {
	private Integer id;
	private String titulo;
	private String artista;
	private Integer añoLanzamiento;
	private List<Cancion> canciones;
	
	public Album(Integer id, String titulo, String artista, Integer añoLanzamiento, List<Cancion> canciones) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.añoLanzamiento = añoLanzamiento;
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
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public Integer getAñoLanzamiento() {
		return añoLanzamiento;
	}
	public void setAñoLanzamiento(Integer añoLanzamiento) {
		this.añoLanzamiento = añoLanzamiento;
	}
	public List<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	
}
