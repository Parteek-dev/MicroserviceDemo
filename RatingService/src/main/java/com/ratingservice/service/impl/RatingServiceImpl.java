package com.ratingservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.entity.Rating;
import com.ratingservice.repo.RatingRepository;
import com.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		int min = 1;  
		int max = 999;  
		//generate unique user id
		int randInteger = (int)(Math.random()*(max-min+1)+min);  
		rating.setRateId(randInteger);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating getRatingByRatingId(Integer ratingId) {
		return ratingRepository.findById(ratingId).orElse(new Rating());
	}

	@Override
	public List<Rating> getRatingByUserId(Integer userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(Integer hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
