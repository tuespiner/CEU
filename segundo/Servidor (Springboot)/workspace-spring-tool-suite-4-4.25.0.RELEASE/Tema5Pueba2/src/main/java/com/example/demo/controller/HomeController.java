package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mensaje", "Bienvenido a Thymeleaf");
		model.addAttribute("nombre1", "hola");
		model.addAttribute("role", "admin");
		List<String> cadenas = Arrays.asList("Juan","Marta","Pablo","Luis","Ana");
		model.addAllAttributes(cadenas);
		return "home";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@GetMapping("/result")
	public String result(Model model) {
		return "result";
	}
	
	@PostMapping("/form")
	public String form(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return "result";
	}
	
	@PostMapping("/libroFormulario")
	public String libroFormulario() {
		return "";
	}
}
