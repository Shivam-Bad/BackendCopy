package com.example.cdb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cdb.entity.User;
import com.example.cdb.service.UserService;


@Controller
@CrossOrigin

@RequestMapping("/page")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerPage() {
		return "Register.html";
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCredential(@RequestBody User user) {
		
		try {
			System.out.println(user);
			userService.insert(user);
			return ResponseEntity.ok("Register successful"); 
		}catch(Exception e) {
			System.out.println("Error occored");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
		
		//return ResponseEntity.ok("Login successful");
		
	}

}