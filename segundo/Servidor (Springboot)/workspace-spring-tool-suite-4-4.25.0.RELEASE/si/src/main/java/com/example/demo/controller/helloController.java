package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloController {

	@GetMapping("/hola")
	public String holaa() {
		return "Helloooooooo";
	}
	
	
	}
