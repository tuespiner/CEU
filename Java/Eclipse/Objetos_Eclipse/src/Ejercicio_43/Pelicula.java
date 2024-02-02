package Ejercicio_43;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private Integer añoEstreno;
	private String titulo;
	private List<Actor> listaActores;
	private Guionista guionista;
	private Director director;

	public Pelicula(Integer añoEstr, String tit, Guionista guio, Director direc) {
		this.listaActores = new ArrayList<>();
		this.añoEstreno = añoEstr;
		this.director = direc;
		this.titulo = tit;
		this.guionista = guio;
	}

	public Pelicula() {
		this.listaActores = new ArrayList<>();
	}

	public Integer getAñoEstreno() {
		return añoEstreno;
	}

	public void setAñoEstreno(Integer añoEstreno) {
		this.añoEstreno = añoEstreno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Actor> getListaActores() {
		return listaActores;
	}

	public void addActores(Actor actor) {
		this.listaActores.add(actor);
	}

	public void setListaActores(List<Actor> listaActor) {
		this.listaActores.addAll(listaActor);
	}

	public Guionista getGuionista() {
		return guionista;
	}

	public void setGuionista(Guionista guionista) {
		this.guionista = guionista;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

}
