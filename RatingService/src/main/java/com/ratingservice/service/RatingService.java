package com.ratingservice.service;

import java.util.List;

import com.ratingservice.entity.Rating;

public interface RatingService {

	//create
	Rating createRating(Rating rating);
	
	//get all
	List<Rating> getAllRatings();
	
	//get single
	Rating getRatingByRatingId(Integer ratingId); 
	
	List<Rating> getRatingByUserId(Integer userId); 
	
	List<Rating> getRatingByHotelId(Integer hotelId); 
	
}
