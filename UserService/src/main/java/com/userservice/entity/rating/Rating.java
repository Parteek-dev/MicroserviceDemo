package com.userservice.entity.rating;

import com.userservice.entity.hotel.Hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Rating {
	
	private int rateId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;

}
