package com.reference.SampleSaleReference.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.entity.Order;
import com.reference.SampleSaleReference.entity.Sales;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	int countByCreatedOnBetweenAndSales(LocalDateTime startTime, LocalDateTime endTime, Sales sale );

}
