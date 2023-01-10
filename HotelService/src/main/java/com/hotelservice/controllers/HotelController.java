package com.hotelservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelservice.entity.hotel.Hotel;
import com.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping	
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		Hotel createHotel = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(createHotel);
	}
	
	@GetMapping("/{hotelId}")	
	public ResponseEntity<Hotel> getHotel(@PathVariable Integer hotelId){
		
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		
		List<Hotel> hotelList = hotelService.getAllHotels();
		return ResponseEntity.ok(hotelList);
	}
	
}
