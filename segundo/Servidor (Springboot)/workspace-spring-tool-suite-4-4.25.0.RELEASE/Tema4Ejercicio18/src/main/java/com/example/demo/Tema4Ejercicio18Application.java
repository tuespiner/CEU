package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Pasaporte;
import com.example.demo.model.Persona;
import com.example.demo.model.Proyecto;

@SpringBootApplication
public class Tema4Ejercicio18Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio18Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Persona persona1 = new Persona("Juan Perez");
		Persona persona2 = new Persona("Ana Lopez");
		Pasaporte pasaporte1 = new Pasaporte("ABC123", persona1);
		Pasaporte pasaporte2 = new Pasaporte("XYZ546", persona2);
		Proyecto proyecto1 = new Proyecto();
		Proyecto proyecto2 = new Proyecto();
	}
	
	

}
