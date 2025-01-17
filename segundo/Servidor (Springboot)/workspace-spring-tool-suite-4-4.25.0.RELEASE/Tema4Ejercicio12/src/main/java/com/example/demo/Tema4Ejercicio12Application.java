package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.serviece.AutorService;

@SpringBootApplication
public class Tema4Ejercicio12Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ejercicio12Application.class, args);
	}
	
	@Autowired
	AutorService service;
	
	public void run(String... args) throws Exception{
		
	}
}
