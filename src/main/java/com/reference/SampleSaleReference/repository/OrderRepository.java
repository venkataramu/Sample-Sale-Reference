package com.reference.SampleSaleReference.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.entity.Order;
import com.reference.SampleSaleReference.entity.Product;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	int countByCreatedOnBetweenAndProduct(LocalDateTime startTime, LocalDateTime endTime, Product product );

}
