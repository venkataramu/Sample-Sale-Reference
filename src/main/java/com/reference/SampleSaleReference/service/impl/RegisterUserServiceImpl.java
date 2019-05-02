package com.reference.SampleSaleReference.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.repository.RegisterUserRepository;
import com.reference.SampleSaleReference.repository.SaleRepository;
import com.reference.SampleSaleReference.service.RegisterUserService;
import com.reference.SampleSaleReference.util.ApplicationException;

@Service
public class RegisterUserServiceImpl implements RegisterUserService { 
	@Autowired
	RegisterUserRepository registerUserRepository;
	
	@Autowired
	SaleRepository saleRepository;

	@Override
	public RegisterUser saveUserForSale(long userId, long saleId) {
		Optional<RegisterUser> registerUser = Optional.ofNullable(registerUserRepository.findRegisterUserByUserIdAndSaleId(userId, saleId));
		
		if(registerUser.isPresent()) {
			throw new ApplicationException("User already Registered for Sale");
		}
		RegisterUser regUser = new RegisterUser(userId, saleId);
		return registerUserRepository.save(regUser);
	}

	public RegisterUserRepository getRegisterUserRepository() {
		return registerUserRepository;
	}

	public void setRegisterUserRepository(RegisterUserRepository registerUserRepository) {
		this.registerUserRepository = registerUserRepository;
	}
	
	

}
