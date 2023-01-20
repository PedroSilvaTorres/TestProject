package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class FullStackDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackDevApplication.class, args);
		System.out.println("All working");
	}
}
