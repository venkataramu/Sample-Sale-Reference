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

import com.reference.SampleSaleReference.model.Product;
import com.reference.SampleSaleReference.model.User;
import com.reference.SampleSaleReference.repository.ProductRepository;
import com.reference.SampleSaleReference.repository.UserRespository;

@RestController
@RequestMapping("/api/")
public class ApiManagement {
	public static  int noOfItemsInSale = 5;
	
	@Autowired
	UserRespository userRepository;
	
	@Autowired 
	ProductRepository productRepository;
	
	@PostMapping("admin/salecount")
	public Product postSaleCountOfProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/users/register")
	public User registerUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PostMapping("users/{id}/products/{productId}/sale")
	public String purchaseOrderonSale(
			@PathVariable(value="id") Long userId,
			@PathVariable(value="productId") Long productId) throws Exception {
		try {
			if(userId > 0) {
				String message = null;
				User user = userRepository.findById(userId).get();
				if(user == null) throw new RestClientException("You are not a Valid user");
				
				Product product = productRepository.findById(productId).get();
				if(product == null)
					throw new RestClientException("Given Product not available in Sale");

				if(product.getSaleCount() > 0) {
					message = "Congrats Your order Successfully Placed. "
							+ "Your Item will be dispatched to this address "+ user.getAddress();
					noOfItemsInSale--;
					int value = product.getSaleCount();
					value = value-1;
					product.setSaleCount(value);
					productRepository.save(product);
					
				} else {
					message = "Sorry Sale is Over";
				}

				return message;
			}

			throw new RestClientException("User Id must be greater than Zero");
		} catch(Exception e) {
			throw new Exception();
		}
		
	}

}
