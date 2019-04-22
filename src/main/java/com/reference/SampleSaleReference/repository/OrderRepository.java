package com.reference.SampleSaleReference.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.model.Order;
import com.reference.SampleSaleReference.model.Product;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	int countByCreatedOnBetweenAndProduct(LocalDateTime startTime, LocalDateTime endTime, Product product );

}
