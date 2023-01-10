package com.userservice.entity.user;

import java.util.List;

import com.userservice.entity.rating.Rating;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	@Id
	@Column(name = "user_id")
	private int userId;
	
	private String name;
	private String email;
	private String about;
	
	@Transient
	private List<Rating> ratings;
	
}
