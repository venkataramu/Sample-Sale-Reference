package com.reference.SampleSaleReference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
