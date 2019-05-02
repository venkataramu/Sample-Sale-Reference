package com.reference.SampleSaleReference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reference.SampleSaleReference.entity.Order;
import com.reference.SampleSaleReference.service.PurchaseItemService;
import com.reference.SampleSaleReference.util.ApplicationException;
import com.reference.SampleSaleReference.util.Response;

@RestController
@RequestMapping("/purchase")
public class PurchaseManagementAPI {
	
	@Autowired
	PurchaseItemService purchaseService;
	
	@PostMapping("/users/{userId}/products/{productId}")
	public ResponseEntity<Response> purchaseAnItem(@PathVariable("userId") long userId, @PathVariable("productId") long productId) {
		try {
			Order order = purchaseService.purchaseAnItem(userId, productId);
			Response response = new Response("Success", order);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch(ApplicationException appExec) {
			Response response = new Response("Failed", appExec.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}
		
	}
	
}
