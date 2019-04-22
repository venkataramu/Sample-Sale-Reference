package com.reference.SampleSaleReference.service;

import com.reference.SampleSaleReference.model.Order;

public interface PurchaseItemService {
	
	public Order purchaseAnItem(long userId, long productId); 
		

}
