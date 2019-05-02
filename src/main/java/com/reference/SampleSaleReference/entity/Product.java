package com.reference.SampleSaleReference.entity;

import java.io.Serializable;
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
public class Product implements Serializable {  
	
	private static final long serialVersionUID = 7207038706386351819L;

	@Id
	@Column(name="product_id", unique=true, nullable = false)
	private long productId;
	
	private String name;
	
	private long saleId;
	
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
	
	public long getSaleId() {
		return saleId;
	}
	
	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}
	
	public Product() {
		
	}
	
	public Product(long productId, String name, LocalDateTime createdOn, long saleId) {
		this.productId = productId;
		this.name = name;
		this.createdOn = createdOn;
		this.saleId = saleId;
	}

}
