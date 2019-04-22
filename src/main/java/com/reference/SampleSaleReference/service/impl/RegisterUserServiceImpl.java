package com.reference.SampleSaleReference.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.repository.RegisterUserRepository;
import com.reference.SampleSaleReference.service.RegisterUserService;
import com.reference.SampleSaleReference.util.ApplicationException;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	@Autowired
	RegisterUserRepository registerUserRepository;

	@Override
	public RegisterUser saveUser(long userId) {
		Optional<RegisterUser> registerUser = registerUserRepository.findById(userId);
		if(registerUser.isPresent()) {
			throw new ApplicationException("User already Registered");
		}
		return registerUserRepository.save(new RegisterUser(userId));
	}

	public RegisterUserRepository getRegisterUserRepository() {
		return registerUserRepository;
	}

	public void setRegisterUserRepository(RegisterUserRepository registerUserRepository) {
		this.registerUserRepository = registerUserRepository;
	}
	
	

}
