package com.indhawk.getfiteat.billing.request;

import java.math.BigDecimal;

public class Item {
	
	private String id;
	
	private String type;
	
	private String name;
	
	private int quantity;
	
	private float price;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemModel [id=" + id + ", type=" + type + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}
