package com.indhawk.getfiteat.order.model;

import java.math.BigDecimal;

public class ItemModel {
	
	private String itemId;
	
	private String type;
	
	private String name;
	
	private int quantity;
	
	private BigDecimal price;

	public ItemModel() {
		super();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemModel [itemId=" + itemId + ", type=" + type + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}
