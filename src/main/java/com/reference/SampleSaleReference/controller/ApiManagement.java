package com.reference.SampleSaleReference.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.reference.SampleSaleReference.model.User;
import com.reference.SampleSaleReference.repository.UserRespository;

@RestController
@RequestMapping("/api/")
public class ApiManagement {
	public static  int noOfItemsInSale = 5;
	
	@Autowired
	UserRespository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/users/register")
	public User registerUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PostMapping("users/{id}/purchase/sale")
	public String purchaseOrderonSale(
			@PathVariable(value="id") Long userId) throws Exception {
		
		String message = null;
		User user = userRepository.findById(userId).get();
		if(user == null) throw new RestClientException("Not a Valid user");
		
		if(noOfItemsInSale > 0) {
			message = "Congrats Your order Successfully Placed. "
					+ "Your Item will be dispatched to this address "+ user.getAddress();
			noOfItemsInSale--;
		} else {
			message = "Sorry Sale is Over";
		}
		
		return message;
		
	}

}
