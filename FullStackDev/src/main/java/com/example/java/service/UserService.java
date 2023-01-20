package com.example.java.service;

import java.util.Optional;

import com.example.java.model.User;

public interface UserService {

	public Optional<User> loadUserByUsername(String username);
	
	public void createUser(User user);
}
