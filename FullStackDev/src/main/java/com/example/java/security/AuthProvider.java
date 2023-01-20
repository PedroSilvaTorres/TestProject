package com.example.java.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.java.model.User;
import com.example.java.repository.UserRepository;

@Component public class AuthProvider implements AuthenticationProvider { 
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override 
	public Authentication authenticate(Authentication authentication) 
			throws AuthenticationException { 
		User usertemp = userRepository.findUserByUsername(authentication.getName());
		if(usertemp == null || !passwordEncoder.matches(authentication.getCredentials().toString(), usertemp.getPassword()))
			throw new BadCredentialsException("Invalid username/password");
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
		        authentication.getPrincipal().toString(),
		        authentication.getCredentials().toString(),
		        usertemp.getAuthorities());
		return token;

	} 
	@Override public boolean supports(Class<?> authentication) { 
		return true; 
	}
}