package com.userservice.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.userservice.entity.rating.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings/{ratinglId}")
	Rating getRating(@PathVariable("ratinglId") Integer id);
	
	@PostMapping("/ratings")
	Rating createRating(Rating rating);
	
	@PutMapping("/ratings/{ratinglId}")
	Rating updateRating(@PathVariable("ratinglId") Integer id);
	
	@DeleteMapping("/ratings/{ratinglId}")
	void deleteRating(@PathVariable Integer ratinglId);
	
}
