package com.reference.SampleSaleReference.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users_sale_mapping", schema="flashsale")
public class RegisterUser implements Serializable {
	
	private static final long serialVersionUID = 6396834493994749636L;
	
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private long userId;
	@Column(name = "sale_id")
	private long saleId;
	private LocalDateTime registerTime;
	
	
	public RegisterUser() {
		
	}
	
	public RegisterUser(long userId, long saleId) {
		this.userId = userId;
		this.saleId = saleId;
		this.registerTime = LocalDateTime.now();
	}
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public LocalDateTime getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
	
	
	
}
