package com.indhawk.getfiteat.payment.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductInfo {

	private String itemId;
	
	private String itemName;
	
	private int quantity;
	
	private String price;
	
	private String type;

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			return jsonMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return "ProductInfo [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price
					+ ", type=" + type + "]";
		}
		
	}
	
	
	
	
}
