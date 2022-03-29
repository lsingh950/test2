package com.apolis.product.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "PRODUCT")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer productId;
	private String productName;
	private Double price;
	private String description;
	public Integer getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public Double getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product(Integer productId, String productName, Double price, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
	}
	
	public Product() {
		
	}
	
}
