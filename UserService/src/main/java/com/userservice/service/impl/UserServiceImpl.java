package com.userservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entity.hotel.Hotel;
import com.userservice.entity.rating.Rating;
import com.userservice.entity.user.User;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.repositories.user.UserRepository;
import com.userservice.service.UserService;
import com.userservice.service.external.HotelService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User saveUser(User user) {
		int min = 1;  
		int max = 999;  
		//generate unique user id
		int randInteger = (int)(Math.random()*(max-min+1)+min);  
		user.setUserId(randInteger);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer userId) {
		
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
		
		// this will call rating service to get the ratings
		
		//Rating[] ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, Rating[].class);
		
		//Need to use @LoadBalanced on restTemplate Bean so that we can user service name instead of server host name and port
		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
		
		System.out.println("Got Ratings - "+ratings);		
		
		// setting hotel information for every Rating 
		List<Rating> listOfRatings = Stream.of(ratings).map(
			rating -> {
				System.out.println("Got HotelId - "+rating.getHotelId());		
			
			//get hotel information
			// using RestTemplate
			ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			@SuppressWarnings("unused")
			Hotel hotel1 = entity.getBody();
				
			//now using feign client 
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
				
			System.out.println("Got Hotel - "+hotel);		
			
			//setting hotel info into Rating
			rating.setHotel(hotel);
			//returning Rating
			return rating;
			}
			
		).collect(Collectors.toList());
		
		user.setRatings(listOfRatings);	
		
		return user;
	}
	

	@Override
	public void updateUser(Integer userId) {
		//userRepository.
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		
	}

	
	
}
