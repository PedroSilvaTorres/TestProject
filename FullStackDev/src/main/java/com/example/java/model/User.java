package com.example.java.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority; 

@Document("User") 
public class User { 

	@Id 
	private String username; 

	private String password;
	
	private String role;

	public User() { 
	} 
	public User(String username, String password, String role) { 
		this.username = username; 
		this.password = password;
		this.role = role;
	} 
	public String getPassword() {    
		return password; 
	} 
	public void setPassword(String password) { 
		this.password = password; 
	} 
	public String getUsername() { 
		return username; 
	} 
	public void setUsername(String username) { 
		this.username = username; 
	} 
	public boolean isAccountNonExpired() { 
		return true; 
	} 
	public boolean isCredentialsNonExpired() { 
		return true; 
	} 
	public boolean isEnabled() { 
		return true; 
	} 
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.getRole()));
        return authorities;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}