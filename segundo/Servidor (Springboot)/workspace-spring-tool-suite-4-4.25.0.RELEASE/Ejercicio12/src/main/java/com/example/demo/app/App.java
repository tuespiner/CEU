package com.example.demo.app;

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

import com.example.demo.model.Libro;

@RestController
@RequestMapping("/libro")
public class App {
	private List<Libro> libros;
	 public App() {
		 List<String> generos1 = new ArrayList<>();
		 generos1.add("terror");
		 generos1.add("suspense");
		 generos1.add("novela");
		 Libro libro1 = new Libro("titulo1", 1, "autor 1", "editorial 1", "1", 2001, generos1);
		 List<String> generos2 = new ArrayList<>();
		 generos2.add("humor");
		 generos2.add("comedia");
		 Libro libro2 = new Libro("titulo2", 2, "autor 1", "editorial 2", "2", 2010, generos2);
		 List<String> generos3 = new ArrayList<>();
		 generos3.add("finanzas");
		 generos3.add("emprendimiento");
		 Libro libro3 = new Libro("titulo3", 3, "autor 2", "editorial 3", "3", 2020, generos3);
		 this.libros = new ArrayList<>();
		 this.libros.add(libro1);
		 this.libros.add(libro2);
		 this.libros.add(libro3);
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<Libro>> getLibros(){
		 return ResponseEntity.ok(libros);
	 }
	 
	 @GetMapping("/{titulo}")
	 public ResponseEntity<Libro> getLibroTitulo(@PathVariable String titulo){
		 for(Libro libro : libros) {
			 if(libro.getTitulo().equals(titulo)) {
				 return ResponseEntity.ok(libro);
			 }
		 }
		 return ResponseEntity.notFound().build();
	 }
	 
	 @PostMapping
	 public ResponseEntity<Libro> setLibro(@RequestBody Libro libro){
		 libros.add(libro);
		 return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping
	 public ResponseEntity<Libro> modLibroEntero(@RequestBody Libro mod){
		 for(Libro libro : libros) {
			 if(libro.getId() == mod.getId()) {
				 libro.setAutor(mod.getAutor());
				 libro.setAñoPublicacion(mod.getAñoPublicacion());
				 libro.setEditorial(mod.getEditorial());
				 libro.setGeneros(mod.getGeneros());
				 libro.setIsbn(mod.getIsbn());
				 libro.setTitulo(mod.getTitulo());
				 return ResponseEntity.noContent().build();
			 }
		 }
		 return ResponseEntity.notFound().build();
	 }
	 
	 @PatchMapping("/{id}")
	 public ResponseEntity<Libro> modLibro(@PathVariable Integer id, @RequestBody Libro mod){
		 for(Libro libro : libros) {
			 if(libro.getId() == id) {
				 if(mod.getAutor() != null) {
					 libro.setAutor(mod.getAutor());
				 }if(mod.getAñoPublicacion() != 0) {
					 libro.setAñoPublicacion(mod.getAñoPublicacion());
				 }if(mod.getEditorial()!=null) {
					 libro.setEditorial(mod.getEditorial());
				 }if(mod.getGeneros()!=null) {
					 libro.setGeneros(mod.getGeneros());
				 }if(mod.getIsbn()!=null) {
					 libro.setIsbn(mod.getIsbn());
				 }if(mod.getTitulo()!=null) {
					 libro.setTitulo(mod.getTitulo());
				 }
				 return ResponseEntity.noContent().build();
			 }
		 }
		 return ResponseEntity.notFound().build();
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Libro> deleteLibro(@PathVariable int id){
		 Iterator<Libro> it = libros.iterator();
		 while(it.hasNext()) {
			 Libro libro = it.next();
			 if(libro.getId() == (id)) {
				 it.remove();
				 return ResponseEntity.noContent().build();
			 }
		 }
		 return ResponseEntity.notFound().build();
	 }
	 
	 @GetMapping("/novelas")
	 public ResponseEntity<List<Libro>> getNovelas(){
		 List<Libro> novelas = new ArrayList<>();
		 for(Libro libro : libros) {
			 for(String genero : libro.getGeneros()) {
				 if(genero.equals("novela")) {
					 novelas.add(libro);
				 }
			 }
		 }
		 return ResponseEntity.ok(novelas);
	 }
	 
	 @GetMapping("/genero/{genero}")
	 public ResponseEntity<List<Libro>> getGenero(@PathVariable String genero){
		 List<Libro> listLibro = new ArrayList<>();
		 for(Libro libro : libros) {
			 for(String generos : libro.getGeneros()) {
				 if(generos.equals(genero)) {
					 listLibro.add(libro);
				 }
			 }
		 }
		 if(listLibro.size() == 0) {
			 return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok(listLibro);
	 }
	 
	 @GetMapping("/autores/{cant}")
	 public ResponseEntity<Map<String, Integer>> getAutoresNLibros(@PathVariable int cant){
		 Map<String, Integer> mapaAutores = new HashMap<String, Integer>();
		 Map<String, Integer> mapaAutoresCant = new HashMap<String, Integer>();
		 for(Libro libro : libros) {
			 if(mapaAutores.isEmpty()) {
				 mapaAutores.put(libro.getAutor(), 1);
			 }else if(mapaAutores.containsKey(libro.getAutor())){
				 mapaAutores.put(libro.getAutor(), mapaAutores.get(libro.getAutor()) + 1);
			 }else {
				 mapaAutores.put(libro.getAutor(), 1);
			 }
			 
		 }
		 Iterator<String> it = mapaAutores.keySet().iterator();
		 while(it.hasNext()) {
			 String key = it.next();
			 if(mapaAutores.get(key)>=cant) {
				 mapaAutoresCant.put(key, mapaAutores.get(key));
			 }
		 }
		 if(mapaAutoresCant.isEmpty()) {
			 return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok(mapaAutoresCant);
		 
	 }
}
