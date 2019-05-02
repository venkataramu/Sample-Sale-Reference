package com.reference.SampleSaleReference.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="sales", schema="flashsale")
public class Sales implements Serializable {
	
	private static final long serialVersionUID = 1731368537471535666L;
	
	@Id
	@Column(name="sale_id", unique=true, nullable=false)
	private long saleId;
	private String saleName;
	private int availableSaleCount;
	private LocalDateTime saleStartTime;
	private LocalDateTime saleEndTime;
	private LocalDateTime createdOn;
	
	public Sales() {
		
	}
	
	public Sales(long saleId, String saleName, LocalDateTime saleStartTime, 
			LocalDateTime saleEndTime) {
		super();
		this.saleId = saleId;
		this.saleName = saleName;
		this.saleStartTime = saleStartTime;
		this.saleEndTime = saleEndTime;
	}
	
	public long getSaleId() {
		return saleId;
	}
	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
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

	public int getAvailableSaleCount() {
		return availableSaleCount;
	}

	public void setAvailableSaleCount(int availableSaleCount) {
		this.availableSaleCount = availableSaleCount;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
}
