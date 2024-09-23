package Examen.Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Productora {
	private String nombre;
	private List<Actor> elenco;
	private List<Pelicula> listaPeliculas;
	
	public Productora() {
		this.elenco = new ArrayList<>();
		this.listaPeliculas = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Actor> getElenco() {
		return elenco;
	}
	public void setElenco(List<Actor> elenco) {
		this.elenco = elenco;
	}
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}
	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	public Map<String, List<Actor>> getMapaActores(){
		Map<String, List<Actor>> mapaActores = new HashMap<>();
		for(Pelicula p : this.listaPeliculas) {
			mapaActores.put(p.getTitulo(),p.getReparto());
		}
		return mapaActores;
	}
	
	public Pelicula getPeliculaMenorReparto() throws PeliculaNotFoundException {
		Pelicula peliculaConMenorReparto = null;
		for(Pelicula p : this.listaPeliculas) {
			if(peliculaConMenorReparto == null) {
				peliculaConMenorReparto = p;
			}else {
				if(peliculaConMenorReparto.getReparto().size() > p.getReparto().size()) {
					peliculaConMenorReparto = p;
				}
			}
		}
		if(peliculaConMenorReparto == null) {
			throw new PeliculaNotFoundException("No hay peliculas");
		}
		return peliculaConMenorReparto;
	}
	
	public BigDecimal getCostePelícula(String titulo) throws PeliculaNotFoundException {
		 BigDecimal costePelicila = null;
		for(Pelicula p :this.listaPeliculas) {
			if(p.getTitulo().equalsIgnoreCase(titulo)) {
				costePelicila = BigDecimal.ZERO;
				for(Actor a :p.getReparto()) {
					costePelicila = costePelicila.add(a.getCoste());
				}
			}
		}
		if(costePelicila == null) {
			throw new PeliculaNotFoundException("No existe pelicula con el título incdicado");
		}
		return costePelicila.setScale(2,RoundingMode.HALF_DOWN);
	}
	
	public List<Pelicula> getLargometrajesEstrenadosConBeneficios(){
		List<Pelicula> largometrajes = new ArrayList<>();
		for(Pelicula p : this.listaPeliculas) {
			if(p.getFechaEstreno() != null &&  p.getFechaEstreno().compareTo(p.getFechaRodaje()) >0 &&
					p.getDuracion() >60 && p.getBeneficios().compareTo(BigDecimal.ZERO) > 0) {
				largometrajes.add(p);
			}
		}
		return largometrajes;
	}
	@Override
	public String toString() {
		String cad = ">>>> Productora: "+this.nombre+" <<<<\n"+
					 "Películas:";
		for(Pelicula p : this.listaPeliculas) {
			cad = cad + "\n\t"+p;
		}
		return cad;
	}
	
	
	
}
