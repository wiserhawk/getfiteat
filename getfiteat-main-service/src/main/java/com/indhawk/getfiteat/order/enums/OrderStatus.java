package com.indhawk.getfiteat.order.enums;

public enum OrderStatus {
	PAYMENT_PENDING("Payment_Pending"),
	CONFIRMED("Confirmed"),
	ASSIGNED("Assinged"),
	SHIPPED("Shipped"),
	DELIVERED("Delivered"),
	REJECTED("Rejected"),
	FAILED("Failed");
	
	public String status;
	
	private OrderStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
