package com.reference.SampleSaleReference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.model.RegisterUser;

public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
	
	
}
