package com.userservice.service;

import java.util.List;

import com.userservice.entity.user.User;

public interface UserService {

	//create 
	User saveUser(User user);
	
	//get all users
	List<User> getAllUsers();
	
	//get user by user id 
	User getUser(Integer userId);
	
	//update 
	void updateUser(Integer id);
	
	//delete
	void deleteUser(Integer id);
}
