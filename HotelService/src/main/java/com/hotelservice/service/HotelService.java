package com.hotelservice.service;

import java.util.List;

import com.hotelservice.entity.hotel.Hotel;

public interface HotelService {

	//create
	Hotel createHotel(Hotel hotel);
	
	//get all
	List<Hotel> getAllHotels();
	
	//get single
	Hotel getHotel(Integer hotelId);
	
}
