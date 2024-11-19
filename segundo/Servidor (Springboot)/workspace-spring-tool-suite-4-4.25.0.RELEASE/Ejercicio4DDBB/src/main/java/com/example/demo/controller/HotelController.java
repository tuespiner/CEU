package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Hotel;
import com.example.demo.service.HotelService;

@RestController
@RequestMapping("hotel")
public class HotelController {
		
	@Autowired
	private HotelService service;
	
	@GetMapping()
	public ResponseEntity<List<Hotel>> getHoteles(){
		return ResponseEntity.ok(service.getHoteles());
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Void> postHotel(@RequestBody Hotel hotel){
		service.postHotel(hotel);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable Integer id){
		if(service.deleteHotel(id)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
