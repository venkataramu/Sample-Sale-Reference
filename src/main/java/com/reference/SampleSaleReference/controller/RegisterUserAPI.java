package com.reference.SampleSaleReference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.service.RegisterUserService;

@RestController
@RequestMapping("/api")
public class RegisterUserAPI {
	@Autowired
	RegisterUserService service;

	@PostMapping("/register/{userId}")
	public RegisterUser registerUser(@PathVariable long userId) {
		return service.saveUser(userId);
	}
	

}
