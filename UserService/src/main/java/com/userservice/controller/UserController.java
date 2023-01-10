package com.userservice.controller;

import java.util.List;

import org.apache.catalina.manager.DummyProxySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.user.User;
import com.userservice.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	int retryCount = 1;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	@GetMapping("/{userId}")
	//@CircuitBreaker(name = "ratingHotelCircuitBreaker", fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelServiceRetry",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "ratingHotelLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable Integer userId) {
		System.out.println(retryCount);
		retryCount++;
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	
	
	public ResponseEntity<User> ratingHotelFallback(Integer userId, Exception exception) {		
		System.out.println("some services are down due to issue");
		User user = new User(44, "Dummy User", "dummy@test.com", "some services are down due to issue", null);
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@PutMapping("deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId){
		userService.deleteUser(userId);
		return ResponseEntity.ok(userId+"# user Deleted.");
	}
	
}
