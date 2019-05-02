package com.reference.SampleSaleReference.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reference.SampleSaleReference.entity.Users;
import com.reference.SampleSaleReference.repository.UserRepository;
import com.reference.SampleSaleReference.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Users saveUser(Users user) throws Exception {
		return userRepository.save(user);
	}

}
