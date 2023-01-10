package com.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.userservice.entity.rating.Rating;
import com.userservice.service.external.RatingService;

@SpringBootTest
@EnableFeignClients
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;
	
//	@Test
//	void contextLoads() {
//	}
	
	@Test
	 void saveRating() {
		
		Rating	rating = Rating.builder().rateId(44).rating(7).userId(45).hotelId(1).feedback("hotel was not good").build();
		ratingService.createRating(rating);
		
	}
	

}
