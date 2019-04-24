package com.reference.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.reference.SampleSaleReference.entity.RegisterUser;
import com.reference.SampleSaleReference.repository.RegisterUserRepository;
import com.reference.SampleSaleReference.service.impl.RegisterUserServiceImpl;
import com.reference.SampleSaleReference.util.ApplicationException;

public class RegisterUserServiceTest {
	
	@Mock
	RegisterUserRepository registerUserRepo;
	
	RegisterUserServiceImpl registerService;
	
	long userId = 12345;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		registerService = new RegisterUserServiceImpl();
		registerService.setRegisterUserRepository(registerUserRepo);
	}
	
	@Test(expected = ApplicationException.class)
	public void testExecuteCheckUserAlreadyRegistered() {
		Mockito.when(registerUserRepo.findById(userId)).thenReturn(Optional.of(new RegisterUser(userId)));
		registerService.saveRegisterUser(userId);
	}


}
