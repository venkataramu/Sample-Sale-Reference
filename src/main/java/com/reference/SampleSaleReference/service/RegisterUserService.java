package com.reference.SampleSaleReference.service;

import com.reference.SampleSaleReference.entity.RegisterUser;

public interface RegisterUserService { 
	
	public RegisterUser saveUserForSale(long userId, long saleId); 

}
