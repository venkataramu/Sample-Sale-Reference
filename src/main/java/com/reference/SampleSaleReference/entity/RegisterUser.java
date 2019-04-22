package com.reference.SampleSaleReference.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registered_users", schema="flashsale")
public class RegisterUser {
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;
	private LocalDateTime registerTime;
	
	public RegisterUser() {
		
	}
	
	public RegisterUser(long userId) {
		this.userId = userId;
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
	
	
}
