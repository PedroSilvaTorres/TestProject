package com.example.java.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.model.User;
import com.example.java.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public Optional<User> loadUserByUsername(String username) { 
		Optional<User> user = userRepository.findById(username);
		return user; 
	} 
	public void createUser(User user) { 
		userRepository.save(user); 
	} 
}
