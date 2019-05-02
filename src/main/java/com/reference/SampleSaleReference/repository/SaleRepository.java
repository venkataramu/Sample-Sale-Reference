package com.reference.SampleSaleReference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.entity.Sales;

public interface SaleRepository extends JpaRepository<Sales, Long>{

}
