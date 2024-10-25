package com.example.demo.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelo.Album;
import com.example.demo.Modelo.Artista;
import com.example.demo.Modelo.Cancion;

@RestController
@RequestMapping("/album")
public class App {
	private List<Album> albumes;
	public App(){
        List<Album> listaAlbumes = new ArrayList<>();
 
        List<Artista> artistas1 = new ArrayList<>();
        artistas1.add(new Artista(1, "Freddie Mercury", "Británico"));
        artistas1.add(new Artista(2, "Brian May", "Británico"));
 
        List<Artista> artistas2 = new ArrayList<>();
        artistas2.add(new Artista(3, "Kurt Cobain", "Americano"));
        artistas2.add(new Artista(4, "Dave Grohl", "Americano"));
 
        List<Cancion> canciones1 = new ArrayList<>();
        canciones1.add(new Cancion(1, "Bohemian Rhapsody", artistas1));
        canciones1.add(new Cancion(2, "Don't Stop Me Now", artistas1));
 
        List<Cancion> canciones2 = new ArrayList<>();
        canciones2.add(new Cancion(3, "Smells Like Teen Spirit", artistas2));
        canciones2.add(new Cancion(4, "Come As You Are", artistas2));
 
        listaAlbumes.add(new Album(1, "A Night at the Opera", "Queen", 1975,canciones1));
        listaAlbumes.add(new Album(2, "Nevermind", "Nirvana",1991,canciones2));
        this.albumes = listaAlbumes;
    }
	
	@GetMapping("/canciones-album/{id}")
	public ResponseEntity<List<Cancion>> getCancionesAlbum(@PathVariable Integer id ){
		for(Album album : this.albumes) {
			if(album.getId() == id) {
				return ResponseEntity.ok(album.getCanciones());
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/canciones-artista/{id}")
		public ResponseEntity<List<Cancion>> getCancionesArtista(@PathVariable Integer id){
			List<Cancion> canciones = new ArrayList<>();
			for(Album album : this.albumes) {
				for(Cancion cancion : album.getCanciones()) {
					for(Artista artista : cancion.getArtistas()) {
						if(artista.getId() == id) {
							canciones.add(cancion);
						}
					}
				}
			}
			if(canciones.isEmpty()) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(canciones);
			}
	}
	
	@GetMapping("/cancion/{id}")
	public ResponseEntity<List<Artista>> getArtistaCancion(@PathVariable Integer id){
		for(Album album : this.albumes) {
			for(Cancion cancion : album.getCanciones()) {
				if(cancion.getId() == id) {
					return ResponseEntity.ok(cancion.getArtistas());
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/artistas")
	public ResponseEntity<Set<Artista>> getArtistasNoRepeat(){
		Set<Artista> artistas = new HashSet();
		for(Album album : this.albumes) {
			for(Cancion cancion : album.getCanciones()) {
				for(Artista artista : cancion.getArtistas()) {
					artistas.add(artista);
				}
			}
		}
		if(artistas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(artistas);
		}
	}
	
	@GetMapping("/artistas/{canciones}")
	public ResponseEntity<Map<String,Integer>> getArtistasNumeroCanciones(@PathVariable Integer canciones){
		Map<String, Integer> artistasNCanciones = new HashMap<>();
		return null;
	}
}

