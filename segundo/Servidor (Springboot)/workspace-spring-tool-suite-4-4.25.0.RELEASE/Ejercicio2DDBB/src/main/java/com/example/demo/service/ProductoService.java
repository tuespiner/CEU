package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repo;
	
	public List<Producto> getProductos(){
		return repo.getProductos();
	}
	
	public Producto getProducto(Integer id){
		return repo.getProducto(id);
	}
}
