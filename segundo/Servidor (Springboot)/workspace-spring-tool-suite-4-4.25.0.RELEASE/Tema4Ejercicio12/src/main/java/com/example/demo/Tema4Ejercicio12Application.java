package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Autor;
import com.example.demo.model.Libro;
import com.example.demo.serviece.AutorService;
import com.example.demo.serviece.LibroService;


@SpringBootApplication
public class Tema4Ejercicio12Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio12Application.class, args);
	}
	
	@Autowired
	AutorService serviceAutor;
	@Autowired
	LibroService serviceLibro;
	
	public void run(String... args) throws Exception{
		Libro libro1 = new Libro("titulo 1");
		serviceLibro.saveLibro(libro1);
		List<Libro> libros = new ArrayList();
		libros.add(libro1);
		Autor autor1 = new Autor("autor 1", libros);
		serviceAutor.getAutores().stream().forEach(System.out::println);
		serviceAutor.saveAutor(autor1);
	}
}
