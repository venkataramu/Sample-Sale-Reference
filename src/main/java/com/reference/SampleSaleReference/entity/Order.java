package com.reference.SampleSaleReference.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 

@Entity
@Table(name="orders", schema="flashsale")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	private Long orderId;
	private LocalDateTime createdOn;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private RegisterUser registerUser;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
	public Order(RegisterUser registeredUser, Product product) {
		this.registerUser = registeredUser;
		this.product = product;
	}
	
}
