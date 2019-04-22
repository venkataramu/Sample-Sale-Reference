package com.reference.SampleSaleReference.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="products", schema="flashsale")
@EntityListeners(AuditingEntityListener.class)
public class Product { 
	
	@Id
	@Column(name="product_id", unique=true, nullable = false)
	private long productId;
	
	private String name;
	
	private long quantityInSale;
	
	private LocalDateTime saleStartTime;
	
	private LocalDateTime saleEndTime;
	
	private LocalDateTime createdOn;
	
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public long getQuantityInSale() {
		return quantityInSale;
	}
	public void setQuantityInSale(long quantityInSale) {
		this.quantityInSale = quantityInSale;
	}
	
	
	public LocalDateTime getSaleStartTime() {
		return saleStartTime;
	}
	public void setSaleStartTime(LocalDateTime saleStartTime) {
		this.saleStartTime = saleStartTime;
	}
	
	public LocalDateTime getSaleEndTime() {
		return saleEndTime;
	}
	public void setSaleEndTime(LocalDateTime saleEndTime) {
		this.saleEndTime = saleEndTime;
	}
	
	
	public Product(long productId, String name, long quantityInSale, LocalDateTime saleStartTime, LocalDateTime saleEndTime, LocalDateTime createdOn) {
		this.productId = productId;
		this.name = name;
		this.quantityInSale = quantityInSale;
		this.saleStartTime = saleStartTime;
		this.saleEndTime = saleEndTime;
		this.createdOn = createdOn;
	}

}
