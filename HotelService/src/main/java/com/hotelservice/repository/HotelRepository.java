package com.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelservice.entity.hotel.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
