package com.indhawk.order;

public enum OrderStatus {

	CONFIRMED("Confirmed"),
	SHIPPED("Shipped"),
	DELIVERED("Delivered"),
	REJECTED("Rejected"),
	FAILED("FAILED");
	
	public String status;
	
	private OrderStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
