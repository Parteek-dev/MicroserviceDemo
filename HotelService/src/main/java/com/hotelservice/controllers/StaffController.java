package com.hotelservice.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {
	
	@GetMapping
	public ResponseEntity<Map<String,List<String>>> getStaffList(){
		
		List<String> listOfStaff = Arrays.asList("Ram","Parteek","Rahul","Vaibhav","Anshul","Rohit");
		
		HashMap<String,List<String>> hashMap = new HashMap<>();
		hashMap.put("Staff", listOfStaff);
		
		return new ResponseEntity<Map<String,List<String>>>(hashMap, HttpStatus.OK);
		
	}

}
