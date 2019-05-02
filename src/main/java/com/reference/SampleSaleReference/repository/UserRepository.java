package com.reference.SampleSaleReference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
}
