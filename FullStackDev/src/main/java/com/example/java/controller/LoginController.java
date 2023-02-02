package com.example.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.java.form.RegisterForm;
import com.example.java.model.User;
import com.example.java.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession; 

@CrossOrigin(origins = "http://127.0.0.1:3000")
@Controller
@EnableWebSecurity
@RequestMapping("/")
public class LoginController {         
	@Autowired private UserServiceImpl userDetailsManager; 
	@Autowired
	private PasswordEncoder passwordEncoder; 

	public String home() { 
		return "home"; 
	}
	@GetMapping("login") 
	public String login(HttpServletRequest request, HttpSession session) { 
		session.setAttribute(
				"error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
				); 
        return "login";
	} 
	
	@GetMapping("register")
	public String register(Model model) { 
		model.addAttribute("registerform", new RegisterForm());
		//userDetailsManager.createUser(new User("user", passwordEncoder.encode("user")));
		return "register"; 
	}
	
	@PostMapping("register")
	public String addUser(@ModelAttribute("registerform") RegisterForm registerForm) {
		User user = new User();
		user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
		user.setUsername(registerForm.getUsername());
		user.setRole(registerForm.getRole());
		userDetailsManager.createUser(user);
		return "login";
	}
	private String getErrorMessage(HttpServletRequest request, String key) {
		Exception exception = (Exception) request.getSession().getAttribute(key); 
		String error = ""; 
		if (exception instanceof BadCredentialsException) { 
			error = "Invalid username and password!"; 
		} else if (exception instanceof LockedException) { 
			error = exception.getMessage(); 
		} else { 
			error = "Invalid username and password!"; 
		} 
		return error;
	}
}