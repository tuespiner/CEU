package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Hotel;
import com.example.demo.repository.HotelRepository;

@Service
public class HotelService {

		@Autowired
		private HotelRepository repo;
		
		public List<Hotel> getHoteles(){
			return repo.getHoteles();
		}
		
		public void postHotel(Hotel hotel) {
			repo.postHotel(hotel);
		}
		
		public Boolean deleteHotel(Integer id) {
			return repo.deleteHotel(id);
		}
}
