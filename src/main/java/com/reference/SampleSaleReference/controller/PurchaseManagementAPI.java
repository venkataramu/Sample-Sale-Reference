package com.reference.SampleSaleReference.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reference.SampleSaleReference.model.Order;
import com.reference.SampleSaleReference.service.PurchaseItemService;

@RestController
@RequestMapping("/api")
public class PurchaseManagementAPI {
	
	@Autowired
	PurchaseItemService purchaseService;
	
	@PostMapping
	public Order purchaseAnItem(@RequestParam("userId") long userId, @RequestParam("productId") long productId) {
		return purchaseService.purchaseAnItem(userId, productId);
	}
	
}
