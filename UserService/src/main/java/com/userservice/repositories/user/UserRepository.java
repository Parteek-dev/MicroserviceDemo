package com.userservice.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
