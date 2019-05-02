package com.reference.SampleSaleReference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.service.RegisterUserService;
import com.reference.SampleSaleReference.util.ApplicationException;
import com.reference.SampleSaleReference.util.Response;

@RestController
@RequestMapping("/register")
public class RegisterUserAPI {
	@Autowired
	RegisterUserService service;

	@PostMapping("/users/{userId}/sale/{saleId}/flashsale")
	public ResponseEntity<Response> registerUser(@PathVariable long userId,
			@PathVariable long saleId) {
		try {
			RegisterUser registerUser = service.saveUserForSale(userId, saleId);
			Response response = new Response("Success", registerUser);
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch(ApplicationException appException) {
			Response response = new Response("Failed", appException.getMessage());
			return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		}
	}
	

}
