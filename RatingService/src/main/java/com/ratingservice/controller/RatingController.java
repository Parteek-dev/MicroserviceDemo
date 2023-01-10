package com.ratingservice.controller;

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

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	//create
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
		
	}
	
	// all ratings
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
		
	}
	
	// all ratings by user
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Integer userId){
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
		
	}
	
	// all ratings by hotel
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable Integer hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
		
	}
	
	// all ratings by hotel
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable Integer ratingId){
		return ResponseEntity.ok(ratingService.getRatingByRatingId(ratingId));

	}
	
}