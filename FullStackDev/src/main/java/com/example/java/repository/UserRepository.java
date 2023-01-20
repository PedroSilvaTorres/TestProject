package com.example.java.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.java.model.User;


public interface UserRepository extends MongoRepository<User, String>{
	
	User findUserByUsername(String username);
	
	Optional<User> findById(String username);
	
	public long count();
}