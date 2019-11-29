package com.indhawk.getfiteat.order.enums;

public enum PaymentMode {
	
	CASH("Cash"),
	ONLINE("Online");
	
	private String paymentType;
	
	private PaymentMode(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
}
