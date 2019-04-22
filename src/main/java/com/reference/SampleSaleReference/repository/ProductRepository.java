package com.reference.SampleSaleReference.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reference.SampleSaleReference.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
