package com.indhawk.order;

public enum PaymentMode {
	
	CASH_ON_DELIVERY("Cash_On_Delivery"),
	WALLETS("Wallets"),
	CARDS("Cards"),
	NETBANKING("Netbanking"),
	UPI_PAYMENT("UPI_Payment"),
	SODEXO_MEAL_CARD("Sodexo_Meal_Card");
	
	private String paymentType;
	
	private PaymentMode(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
}
