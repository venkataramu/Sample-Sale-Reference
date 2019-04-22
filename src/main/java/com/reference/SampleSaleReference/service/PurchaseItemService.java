package com.reference.SampleSaleReference.service;

import com.reference.SampleSaleReference.entity.Order;

public interface PurchaseItemService {
	
	public Order purchaseAnItem(long userId, long productId); 
		

}
