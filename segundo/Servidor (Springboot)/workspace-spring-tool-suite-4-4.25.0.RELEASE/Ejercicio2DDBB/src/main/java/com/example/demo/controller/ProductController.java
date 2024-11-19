package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;


@RestController
@RequestMapping("Producto")
public class ProductController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping()
	public ResponseEntity<List<Producto>> getProductos(){
		return ResponseEntity.ok(service.getProductos());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable Integer id){
		Producto producto = service.getProducto(id);
		if(producto == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(producto);
		}
	}
}
