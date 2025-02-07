package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

@Controller
public class VistaController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/")
	public String inicio( Model model) {
		model.addAttribute("clientes", service.getAllClientes());
		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String inicio(@PathVariable Integer id , Model model) {
		model.addAttribute("clienteDetalle", service.getClienteById(id));
		return "detallesCliente";
	}

	
	@GetMapping("/detallesCliente")
	public String detallesCliente( Model model) {
		return "detallesCliente";
	}
	
	@GetMapping("/agregarCliente")
	public String agregarCliente( Model model) {
		model.addAttribute("clienteNuevo", new Cliente());
		return "agregarCliente";
	}
	
	@PostMapping("/agregarCliente")
	public String agregarCliente(@ModelAttribute Cliente cliente, Model model) {
		service.saveCliente(cliente);
		return "redirect:/";
	}
	
	@GetMapping("/buscarPorCiudad")
	public String buscarPorCiudad(Model model) {
		return "buscarPorCiudad";
	}
	
	@PostMapping("/buscarPorCiudad")
	public String buscarPorCiudad(@RequestParam String ciudad,  Model model) {
		model.addAttribute("clientesCiudad", service.findClientesByCiudad(ciudad));
		model.addAttribute("ciudad", ciudad);
		model.addAttribute("nulo", service.findClientesByCiudad(ciudad).isEmpty());
		return "buscarPorCiudad";
	}
}
