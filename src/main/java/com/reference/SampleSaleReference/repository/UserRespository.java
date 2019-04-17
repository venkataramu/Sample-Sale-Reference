package com.reference.SampleSaleReference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.model.User;

public interface UserRespository extends JpaRepository<User, Long>{

}
