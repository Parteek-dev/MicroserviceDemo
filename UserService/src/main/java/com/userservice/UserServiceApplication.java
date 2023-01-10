package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableEurekaClient, we don't need this annotation because we are using 
 * <spring-cloud.version>2022.0.0</spring-cloud.version> 
 * <version>3.0.1</version>
 * that is a latest version
 *
 */

@SpringBootApplication
@EnableFeignClients // this annotation is an alternative of RestTemplate provided by Netflix
 public class UserServiceApplication {

	/**
	 * @LoadBalanced is used so that we don't need to right this
	 * restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, Rating[].class);
	 * now we can use the service name instead of server name and port
	 * restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
	 */
	@Bean
	@LoadBalanced  
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
