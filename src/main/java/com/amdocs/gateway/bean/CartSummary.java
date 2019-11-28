package com.amdocs.gateway.bean;

import java.util.List;

public class CartSummary {
	private List<Product> cartItems;
	private double shippingChares = 100;
	private double grandTotal;
	private int tax = 10;
	private double total;
	private double taxAmount;

	public void setCartItems(List<Product> cartItems) {
		this.cartItems = cartItems;
		double totalPrice = 0;
		if (this.cartItems != null) {
			for (Product product : this.cartItems) {
				totalPrice = totalPrice + (product.getPrice() * product.getQuantity());
			}
		} else {
			return;
		}
		this.total = totalPrice;
		this.taxAmount = (this.total * this.tax) / 100;
		this.grandTotal = this.total + this.shippingChares + this.taxAmount;
	}

	public List<Product> getCartItems() {
		return cartItems;
	}

	public double getShippingChares() {
		return shippingChares;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public int getTax() {
		return tax;
	}

	public double getTotal() {
		return total;
	}

	public double getTaxAmount() {
		return taxAmount;
	}
}
