package com.reference.SampleSaleReference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reference.SampleSaleReference.entity.Users;
import com.reference.SampleSaleReference.service.UserService;

@RestController
@RequestMapping("/users")
public class UserManagementAPI { 
	@Autowired
	UserService userService;
	
	@PostMapping
	public void saveUser(@RequestBody Users users) throws Exception {
		userService.saveUser(users);
	}
}
