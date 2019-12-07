package com.amdocs.gateway.bean;

import java.util.Date;
import java.util.List;

public class Product {

	private long productId;

	private String productName;

	private String imageUrl;

	private double price;

	private String productType;

	private List<ProductCharacteristic> productCharacteristics;

	private Date creationDate;

	private Date updationDate;

	private int quantity = 1;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<ProductCharacteristic> getProductCharacteristics() {
		return productCharacteristics;
	}

	public void setProductCharacteristics(List<ProductCharacteristic> productCharacteristics) {
		this.productCharacteristics = productCharacteristics;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
