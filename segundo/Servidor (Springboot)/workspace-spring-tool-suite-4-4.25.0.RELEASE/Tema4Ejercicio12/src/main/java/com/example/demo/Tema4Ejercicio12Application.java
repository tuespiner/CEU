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

@SpringBootApplication
public class Tema4Ejercicio12Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio12Application.class, args);
	}
	
	@Autowired
	AutorService autorService;
	
	public void run(String... args) throws Exception{
		Libro libro1 = new Libro("libro1");
		List<Libro> lista = new ArrayList();
		lista.add(libro1);
		Autor autor1 = new Autor("autor1", lista );
		autorService.saveAutor(autor1);
		
		
		List<Autor> autores = autorService.getAutores();
		autores.stream().forEach(System.out::println);
		
		
	}
}
